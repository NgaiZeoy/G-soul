package cn.com.gamersoul.entity;

import java.io.Serializable;

public class SortTitle implements Serializable {
    private Integer id;
    private String title;

    @Override
    public String toString() {
        return "SortTitle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
