package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Order;
import cn.com.gamersoul.vo.OrderGameVO;
import cn.com.gamersoul.vo.SelectOrderGameIdVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PaymentMapper {
    //生成一条订单
    @Insert("insert into `order`(order_no,order_name,order_total,user_id,trade_status,code) values(#{order_no},#{order_name},#{order_total},#{user_id},#{trade_status},#{code})")
    void addOrder(String order_no,String order_name,Float order_total,Integer user_id,String trade_status,String code);

    //根据订单号修改订单的交易状态
    @Update("UPDATE `order` SET trade_status=#{trade_status} WHERE order_no=#{order_no}")
    void updateOrderTradeStatus(String trade_status,String order_no);

    //在订单游戏表中添加数据
    @Insert("INSERT INTO order_game (order_no,game_id) VALUES (#{order_no},#{game_id})")
    void insertOrderGame(String order_no,Integer game_id);

    //根据订单号返回集合里只有一个订单对象的订单集合
    @Select("select * from `order` where order_no=#{order_no}")
    List<Order> selectByOrderNoList(String order_no);

    //根据订单号返回订单里购买的所有游戏
    @Select("SELECT `order`.order_no,game.game_id,`name`,img_title_url,cur_price\n" +
            "FROM `order`\n" +
            "LEFT JOIN order_game ON `order`.order_no=order_game.order_no\n" +
            "LEFT JOIN game ON order_game.game_id = game.game_id\n" +
            "WHERE `order`.order_no=#{order_no}")
    List<OrderGameVO> selectOrderGamesByOrderNo(String order_no);

    //根据订单号返回对应的订单对象
    @Select("select * from `order` where order_no=#{order_no}")
    Order selectByOrderNo(String order_no);

    //根据订单号查找交易成功订单中的游戏
    @Select("SELECT order_game.game_id\n" +
            "FROM `order`\n" +
            "LEFT JOIN order_game ON `order`.order_no=order_game.order_no\n" +
            "WHERE user_id=#{user_id} AND trade_status=#{trade_status} AND `order`.order_no=#{order_no}")
    List<SelectOrderGameIdVO> selectOrderGameId(Integer user_id,String trade_status,String order_no);


}
