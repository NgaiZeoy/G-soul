package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDetailMapper {

    @Select("select * from user_detail where user_id=#{useId}")
    UserDetail selectByUserId(Integer userId);

    @Select("select user_id,nickname,user_avatar_url,signature\n" +
            "from user_detail \n" +
            "WHERE user_id \n" +
            "in (select friend_id FROM friend WHERE user_id=#{userId});")
    List<UserDetail>  selectFriendByUserId(Integer userId);

    @Update("update user_detail set nickname=#{nickname},user_avatar_url=#{user_avatar_url},signature=#{signature} where user_id=#{user_id}")
    int userDetailUpdate (String nickname,String user_avatar_url,String signature ,Integer user_id);
}
