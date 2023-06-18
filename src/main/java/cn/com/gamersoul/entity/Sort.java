package cn.com.gamersoul.entity;

public class Sort {
    private Integer sort_id;
    private String sort_title;
    private String sort_item;

    @Override
    public String toString() {
        return "Sort{" +
                "sort_id=" + sort_id +
                ", sort_title='" + sort_title + '\'' +
                ", sort_item='" + sort_item + '\'' +
                '}';
    }

    public Integer getSort_id() {
        return sort_id;
    }

    public void setSort_id(Integer sort_id) {
        this.sort_id = sort_id;
    }

    public String getSort_title() {
        return sort_title;
    }

    public void setSort_title(String sort_title) {
        this.sort_title = sort_title;
    }

    public String getSort_item() {
        return sort_item;
    }

    public void setSort_item(String sort_item) {
        this.sort_item = sort_item;
    }
}
