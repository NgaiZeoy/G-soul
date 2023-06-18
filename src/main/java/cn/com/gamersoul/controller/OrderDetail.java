package cn.com.gamersoul.controller;

import lombok.Data;

@Data
public class OrderDetail {

    private String order_no;
    private String trade_status;
    private String code;
    private Integer game_id;
    private String game_name;
    private String img_title_url;
    private Double cur_price;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order_no='" + order_no + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", game_code='" + code + '\'' +
                ", game_id=" + game_id +
                ", game_name='" + game_name + '\'' +
                ", img_title_url='" + img_title_url + '\'' +
                ", cur_price=" + cur_price +
                '}';
    }


}
