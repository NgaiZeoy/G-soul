package cn.com.gamersoul.vo;

import lombok.Data;

@Data
public class OrderGameVO {
    //订单号
    private String order_no;
    //游戏id
    private Integer game_id;
    //游戏名
    private String name;
    //游戏图片
    private String img_title_url;
    //价格
    private Double cur_price;
}
