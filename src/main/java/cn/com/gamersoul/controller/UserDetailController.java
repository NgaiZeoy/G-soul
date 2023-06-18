package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.entity.UserDetail;
import cn.com.gamersoul.mapper.UserDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserDetailController {

    @Autowired(required = false)
    UserDetailMapper userDetailMapper;

    @RequestMapping("/userDetail/selectByUserId")
    UserDetail selectByUserId(HttpSession session){
        User u = (User) session.getAttribute("user");
        Integer userId = u.getUser_id();
        //System.out.println(userDetailMapper.selectByUserId(userId));
        return userDetailMapper.selectByUserId(userId);
    }
    @RequestMapping("/userDetail/selectFriendByUserId")
    //select nickname,user_avatar_url from user_detail WHERE user_id in (select friend_id FROM friend WHERE user_id=1);
    public List<UserDetail> selectFriendByUserId(HttpSession session){
        User u = (User) session.getAttribute("user");
        Integer userId = u.getUser_id();
        //System.out.println(userDetailMapper.selectFriendByUserId(userId));
        return userDetailMapper.selectFriendByUserId(userId);
    }

    @RequestMapping("/firend/selectFriendByUserI")
    //select nickname,user_avatar_url from user_detail WHERE user_id in (select friend_id FROM friend WHERE user_id=1);
    public List<UserDetail> selectFriendByUserId(Integer userId){

        return userDetailMapper.selectFriendByUserId(userId);
    }

    @RequestMapping("/modifyUserSession")
    public User modifyUserSession(@RequestBody  UserDetail userDetail,HttpSession session){
        String userAvatar = userDetail.getUser_avatar_url();
        User user = (User) session.getAttribute("user");
        user.setUser_avatar_url(userAvatar);
        session.setAttribute("user", user);
        return user;
    }

    @RequestMapping("/userdetail/update")
    public int userDetailUpdate(@RequestBody UserDetail userDetail,HttpSession session){
        //System.out.println("userDetail = " + userDetail);
        User u = (User) session.getAttribute("user");
        if (u==null){
            return 0;
        }
        String user_avatar_url = userDetail.getUser_avatar_url();
        String nickname = userDetail.getNickname();
        String signature = userDetail.getSignature();
        Integer user_id = u.getUser_id();
        int i = userDetailMapper.userDetailUpdate(nickname,user_avatar_url,signature,user_id);
        //System.out.println(i);
        if (i==1){
            return 1;
        }else {
            return 2;
        }
    }




}
