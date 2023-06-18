package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.entity.UserDetail;
import cn.com.gamersoul.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class FriendController {

    @Autowired()
    FriendMapper friendMapper;


    @RequestMapping("/friend/isAttention")
    public int selectByFriendId(Integer friendId, HttpSession session){
        User u = (User) session.getAttribute("user");
        int i = friendMapper.selectByFriendId(u.getUser_id(), friendId);
        return i;
    }

    @RequestMapping("/friend/selectByUserId")
    public UserDetail selectByUserId(Integer userId){
        return friendMapper.selectByUserId(userId);
    }

    @RequestMapping("/friend/insert")
    public int isnert( Integer friendUserId ,HttpSession session){
        User u = (User) session.getAttribute("user");
        if (u==null){
            return 1;
        }
        Integer userId = u.getUser_id();
        friendMapper.insert(userId,friendUserId);
        return 2;
    }
    @RequestMapping("/friend/delete")
    public int delete(Integer friendUserId, HttpSession session){
        System.out.println("friendUserId = " + friendUserId);
        User u = (User) session.getAttribute("user");
        if (u==null){
            return 1;
        }
        Integer userId = u.getUser_id();
        friendMapper.delete(userId,friendUserId);
        return 2;
    }




}
