package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired(required = false)
    OrderDetailMapper orderDetailMapper;

    //通过用户id查询订单
    @RequestMapping("/orderDetail/selectOrderDeatilByUserId")
    public List<OrderDetail> selectOrderDeatilByUserId(HttpSession session){
        User u = (User) session.getAttribute("user");
        Integer userId = u.getUser_id();
        List<OrderDetail> orderDetails = orderDetailMapper.selectOrderDetaileByUserId(userId);
        System.out.println(orderDetails);
        return orderDetails;
    }

}
