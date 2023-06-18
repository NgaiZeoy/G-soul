package cn.com.gamersoul.mapper;

import cn.com.gamersoul.controller.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    @Select("select o.order_no,o.code,g.game_id,g.`name` game_name,g.img_title_url,g.cur_price,\n" +
            "case o.trade_status when 'TRADE_FAILED' then '支付失败' when 'TRADE_SUCCESS' then '支付成功' end as trade_status\n" +
            "from `order` o\n" +
            "left join order_game og on og.order_no = o.order_no\n" +
            "left join game g on og.game_id = g.game_id\n" +
            "where user_id = #{userId} and o.trade_status = 'TRADE_SUCCESS'")
    List<OrderDetail> selectOrderDetaileByUserId(int userId);
}
