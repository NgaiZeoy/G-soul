package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.UserDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FriendMapper {

    @Select("select count(*) from friend where user_id = #{user_id} and friend_id = #{friendId}")
    int selectByFriendId( Integer user_id,Integer friendId);

    @Select("select * from user_detail where user_id=#{userId}")
    UserDetail selectByUserId(Integer userId);

    @Insert("insert into friend values(null,#{userId},#{friendUserId})")
    int insert(Integer userId,Integer friendUserId);

    @Delete("delete from friend where user_id=#{userId} and friend_id = #{friendUserId}")
    int delete(Integer userId,Integer friendUserId);
}

