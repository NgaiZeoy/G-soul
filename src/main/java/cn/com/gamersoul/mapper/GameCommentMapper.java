package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.GameComment;
import cn.com.gamersoul.vo.GameCommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameCommentMapper {

    @Insert("insert into game_comment value(null,#{game_id},#{user_id},#{nickname},#{parent_id},#{comment},#{urls},#{is_parent})")
    void insert(GameComment comment);

    @Select("select * from game_comment where user_id= #{userId}")
    List<GameComment> selectById( Integer userId);


    @Select("select * from game_comment where game_id=#{gameId} and user_id= #{userId}")
    List<GameComment> selectGameById(Integer gameId, Integer userId);

    @Select("select * from game_comment where game_id = #{gameId} and is_parent = 1 order by comment_id desc")
    List<GameCommentVO> selectCommentGameById(Integer gameId);

    @Select("select * from game_comment where parent_id = #{parent_id} and is_parent = 0")
    List<GameComment> gameComment(Integer parentId);
}
