package cn.com.gamersoul.entity;

public class Label {
    private Integer game_id;
    private String sort_item;

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getSort_item() {
        return sort_item;
    }

    public void setSort_item(String sort_item) {
        this.sort_item = sort_item;
    }

    @Override
    public String toString() {
        return "Label{" +
                "game_id=" + game_id +
                ", sort_item='" + sort_item + '\'' +
                '}';
    }
}
