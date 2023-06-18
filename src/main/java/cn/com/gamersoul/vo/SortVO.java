package cn.com.gamersoul.vo;

import cn.com.gamersoul.entity.Sort;

import java.util.List;

public class SortVO {
    private Integer sort_id;
    private String sort_title;
    List<Sort> sorts;

    @Override
    public String toString() {
        return "SortVO{" +
                "sort_id=" + sort_id +
                ", sort_title='" + sort_title + '\'' +
                ", sorts=" + sorts +
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

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }
}
