package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.ReviewComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewCommentMapper {

    @Insert("insert into review_comment value(null,#{comment_id},#{user_id},#{game_id},#{comment},#{nickname})")
    int reviewInsert(ReviewComment reviewComment);

    @Select("select * from review_comment where comment_id=#{commentId}")
    List<ReviewComment> selectByCommentId(Integer commentId);

}
