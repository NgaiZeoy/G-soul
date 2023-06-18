package cn.com.gamersoul.dto;

import cn.com.gamersoul.entity.SortTitle;

import java.io.Serializable;
import java.util.List;

public class SortItemDTO implements Serializable {
    private Integer game_id;
    private List<Integer> list;

    @Override
    public String toString() {
        return "SortItem{" +
                "game_id=" + game_id +
                ", list=" + list +
                '}';
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}

