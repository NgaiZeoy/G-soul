package cn.com.gamersoul.entity;

public class Shopping {
    private Integer shop_id;
    private Integer user_id;
    private Integer game_id;

    @Override
    public String toString() {
        return "Shopping{" +
                "shop_id=" + shop_id +
                ", user_id=" + user_id +
                ", game_id=" + game_id +
                '}';
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }
}
