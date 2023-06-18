package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.NewUser;
import cn.com.gamersoul.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user values(null,#{username},#{mem_phone},#{password},null)")
    void insert(NewUser newUser);

    //根据用户名查用户是否存在
    @Select("select `user`.user_id,`password`,nickname,user_avatar_url\n" +
            "FROM `user`\n" +
            "LEFT JOIN user_detail ON `user`.user_id=user_detail.user_id\n" +
            "WHERE username=#{username}")
    User selectByUsername(String username);

    //根据电话号码查用户是否存在
    @Select("select `user`.user_id,`password`,nickname,user_avatar_url\n" +
            "FROM `user`\n" +
            "LEFT JOIN user_detail ON `user`.user_id=user_detail.user_id\n" +
            "WHERE mem_phone=#{memPhone}")
    User selectByMemPhone(String memPhone);

    @Select("select * from user")
    List<User> selectAdmin();

    @Update("update user set identity=#{identity} where user_id=#{user_id}")
    int updateIdentity(Integer identity,Integer user_id);

    @Delete("delete from user where user_id=#{userId}")
    int deleteUuser(Integer userId);

    @Select("select identity from user where username=#{username}")
    Integer selectIdentity(String username);

}
