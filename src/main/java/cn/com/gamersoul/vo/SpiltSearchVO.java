package cn.com.gamersoul.vo;

import lombok.Data;

@Data
public class SpiltSearchVO {

    private Integer game_id;
    private String img_title_url;
    private String name;
    private String discount;
    private String  old_price;
    private Double cur_price;
    private String small_imgs;

}
