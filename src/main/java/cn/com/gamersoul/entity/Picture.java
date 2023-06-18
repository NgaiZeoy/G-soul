package cn.com.gamersoul.entity;
/**
 * 游戏类图片类
 * */
public class Picture {
    private Integer img_id;
    private Integer game_id;
    private String game_image_url;

    @Override
    public String toString() {
        return "Picture{" +
                "img_id=" + img_id +
                ", game_id=" + game_id +
                ", game_image_url='" + game_image_url + '\'' +
                '}';
    }

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getGame_image_url() {
        return game_image_url;
    }

    public void setGame_image_url(String game_image_url) {
        this.game_image_url = game_image_url;
    }
}
