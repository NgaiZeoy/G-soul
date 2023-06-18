package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.SortTitle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SortTitleMapper {

    @Select("select * from sort_title")
    List<SortTitle> selectSortTitle();

    @Select("insert into sort_title values(null,#{title})")
    void insertSortTitle(String title);
}
