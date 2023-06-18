package cn.com.gamersoul.controller;
 
import cn.com.gamersoul.dto.addNewOrderDTO;
import cn.com.gamersoul.entity.Game;
import cn.com.gamersoul.entity.Order;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.GameMapper;
import cn.com.gamersoul.mapper.PaymentMapper;
import cn.com.gamersoul.mapper.ShoppingMapper;
import cn.com.gamersoul.service.PayService;
import cn.com.gamersoul.util.CDKEY;
import cn.com.gamersoul.util.OrderUtil;
import cn.com.gamersoul.vo.OrderGameVO;
import cn.com.gamersoul.vo.SelectOrderGameIdVO;
import com.alibaba.fastjson.JSONObject;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
/**
 *  支付宝支付，控制器
 *
 * @author wangziyang
 * */
@RestController
@RequestMapping(value = "/pay")
@AllArgsConstructor
public class PayController {

    @Autowired(required = false)
    PaymentMapper mapper;

    @Autowired(required = false)
    GameMapper gameMapper;

    @Autowired(required = false)
    ShoppingMapper shoppingMapper;

    @Autowired(required = false)
    RedisTemplate<String, Serializable> redisTemplate;

    private PayService payService;
 
    /**
     *  下单支付
     * */
    @PostMapping("/confirm")
    public Object pay (HttpServletRequest request) throws Exception {
        //把隐藏域的参数赋值给order_no
        String order_no = request.getParameter("order_no");
        //通过新得到的order_no去获取对应的订单对象
        Order order = mapper.selectByOrderNo(order_no);
        //调用方法把参数传进去
        return payService.pay(order);
    }

    //购物车界面提交订单
    @PostMapping("/submitOrder")
    public void submitOrder(@RequestBody addNewOrderDTO addNewOrderDTO, HttpSession session){
        String[] gameIds = addNewOrderDTO.getCheckList();//界面传回来的订单里的游戏数组
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < gameIds.length; i++){
            //根据游戏id查找游戏
            Game game = gameMapper.selectById(Integer.parseInt(gameIds[i]));
            //把查找出来的游戏添加到集合中
            games.add(game);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aggregate",addNewOrderDTO.getAggregate());
        jsonObject.put("games",games);
        session.setAttribute("addNewOrder",jsonObject);
    }

    //生成订单，并根据订单号查找订单
    @GetMapping("/addOrder")
    public List<Order> addOrder(HttpSession session){
        //通过session获取购物车界面提交的订单
        JSONObject jsonObject = (JSONObject) session.getAttribute("addNewOrder");
        //获取当前登录的用户对象
        User user = (User) session.getAttribute("user");
        //获取用户id
        Integer userId = user.getUser_id();
        //获取总价
        float aggregate = (float)jsonObject.getInteger("aggregate");
        //生成游戏兑换码
        String cdkey = CDKEY.getRandomString(26);
        //生成订单号
        String orderNo = OrderUtil.getOrderNo();
        //生成交易状态，默认为TRADE_FAILED(失败)
        String trade_status = "TRADE_FAILED";
        //生成订单
        mapper.addOrder(orderNo,"我的订单",aggregate,userId,trade_status,cdkey);
        //获取提交订单里的游戏集合，并添加到订单游戏表中
        List<Game> games = (List<Game>) jsonObject.get("games");
        for (int i = 0; i < games.size(); i++){
            mapper.insertOrderGame(orderNo,games.get(i).getGame_id());
        }
        //根据订单号把得到的订单集合传给前端(查到的订单集合里肯定只有一个订单对象)
        return mapper.selectByOrderNoList(orderNo);
    }

    //根据订单号返回订单里购买的所有游戏
    @GetMapping("/selectOrderGamesByOrderNo")
    public List<OrderGameVO> selectOrderGamesByOrderNo(String orderNo){
        return mapper.selectOrderGamesByOrderNo(orderNo);
    }

    //支付结束后支付宝把支付的信息异步回调到这里
    @PostMapping("/notify")
    public Object notifyAsync(HttpServletRequest request) throws UnsupportedEncodingException {
        //Map map = request.getParameterMap();
        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "GBK");
        // 交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "GBK");
        //获取用户id
        Integer userId = (Integer) redisTemplate.opsForValue().get("userId");
        System.out.println("用户id为："+userId);
        //如果交易状态为交易成功，则修改订单的交易状态为TRADE_SUCCESS
        if ("TRADE_SUCCESS".equals(trade_status)){
            mapper.updateOrderTradeStatus(trade_status,out_trade_no);
            //根据订单号查找订单中的游戏，并且把对应的游戏从用户购物车中删除
            List<SelectOrderGameIdVO> gameIds = mapper.selectOrderGameId(userId,trade_status,out_trade_no);
            System.out.println(gameIds);
            for (int i = 0; i < gameIds.size(); i++){
                Integer id = shoppingMapper.selectIdtByUserIdAndGameId(userId,gameIds.get(i).getGame_id());
                int num = shoppingMapper.deleteUserShoppingCarInfo(id);
                if (num==1){
                    System.out.println("删除用户id="+userId+",数据id="+id+"的数据删除成功");
                }
            }
            return "ok";
        }
        return "failed";
    }
}