package cn.com.gamersoul.entity;

/**
 * 游戏类
 */
public class Game {
    private Integer game_id;
    private String name;
    private String content;
    private Integer sale_count;
    private String discount;
    private String  old_price;
    private Double cur_price;
    private String img_title_url;
    private String status;
    private String small_imgs;
    private String mid_img;

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", sale_count=" + sale_count +
                ", discount='" + discount + '\'' +
                ", old_price='" + old_price + '\'' +
                ", cur_price=" + cur_price +
                ", img_title_url='" + img_title_url + '\'' +
                ", status='" + status + '\'' +
                ", small_imgs='" + small_imgs + '\'' +
                ", mid_img='" + mid_img + '\'' +
                '}';
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSale_count() {
        return sale_count;
    }

    public void setSale_count(Integer sale_count) {
        this.sale_count = sale_count;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOld_price() {
        return old_price;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }

    public Double getCur_price() {
        return cur_price;
    }

    public void setCur_price(Double cur_price) {
        this.cur_price = cur_price;
    }

    public String getImg_title_url() {
        return img_title_url;
    }

    public void setImg_title_url(String img_title_url) {
        this.img_title_url = img_title_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSmall_imgs() {
        return small_imgs;
    }

    public void setSmall_imgs(String small_imgs) {
        this.small_imgs = small_imgs;
    }

    public String getMid_img() {
        return mid_img;
    }

    public void setMid_img(String mid_img) {
        this.mid_img = mid_img;
    }
}
