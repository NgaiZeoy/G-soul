package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Label;
import cn.com.gamersoul.entity.Sort;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SortMapper {

//    @Select("select sort.sort_id,sort.sort_item \n" +
//            "from game_sort,sort,game \n" +
//            "WHERE game.game_id = game_sort.game_id and sort.sort_id=game_sort.sort_id and game.game_id= #{game_id}\n")
//    List<Sort> selectBysId(int game_id);

    @Select("SELECT game.game_id,sort_item\n" +
            "FROM game\n" +
            "LEFT JOIN game_sort ON game.game_id=game_sort.game_id\n" +
            "LEFT JOIN sort ON game_sort.sort_id=sort.sort_id\n" +
            "WHERE game.game_id=#{game_id}")
    List<Label> selectBysId(int game_id);

    @Select("select * from sort where sort_id=#{sort_id}")
    Label selectById(int sort_id);

    @Select("select * from sort where sort_title = #{title}")
    public List<Sort> selectItemByTitle(String title);

    @Insert("insert into sort values(null,#{sort_title},#{sort_item})")
    int insert(Sort sort);

    @Delete("delete from sort where sort_title = #{title} and sort_item = #{item}")
    void deleteSort(String title,String item);

    //根据游戏Id把游戏分类整个删掉
    @Delete("delete from game_sort where game_id = #{gameId}")
    int deleteGameSortByGameId(Integer gameId);

    //插入根据修改信息传过来的数据    //插入数据
    @Insert("insert into game_sort values(null,#{gameId},#{item})")
    void updateGameSortDoInsert(Integer gameId ,Integer item);

    @Select("select sort_id from game_sort where game_id=#{gameId}")
    List<String> selectItemByGameId(Integer gameId);


}
