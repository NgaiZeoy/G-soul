package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.NewUser;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @Autowired(required = false)
    RedisTemplate<String, Serializable> redisTemplate;

    /*
        用户名登录功能
     */
    @RequestMapping("/login")
    public int login(@RequestBody User user, HttpSession session, HttpServletResponse response) {
        User u = mapper.selectByUsername(user.getUsername());
        return judgeLogin(user,u,session,response);
    }

    /*
        电话号码登录功能
     */
    @RequestMapping("/phoneLogin")
    public int phoneLogin(@RequestBody User user, HttpSession session, HttpServletResponse response){
        User u = mapper.selectByMemPhone(user.getMem_phone());
        return judgeLogin(user,u,session,response);
    }

    /*解决登录功能的代码冗余*/
    public int judgeLogin(User userDTO, User userVO, HttpSession session,HttpServletResponse response){
        if (userVO != null) {
            if (userVO.getPassword().equals(userDTO.getPassword())) {
                //登录成功后把从数据库里面查询到的用户对象保存到Session回话对象中
                session.setAttribute("user", userVO);
                //用redis存user
                ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();
                opsForValue.set("userId", userVO.getUser_id());
                //判断是否需要记住用户名和密码
                if (userDTO.isRem()) {
                    //创建Cookie记住用户名和密码
                    Cookie c1 = new Cookie("username", userDTO.getUsername());
                    Cookie c2 = new Cookie("password", userDTO.getPassword());
                    //设置Cookie保存数据的时长
                    c1.setMaxAge(60 * 60 * 24 * 30);
                    c2.setMaxAge(60 * 60 * 24 * 30);
                    //把Cookie下发给客户端
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                return 1;
            }
            return 3;
        }
        return 2;
    }

    /*
        注册功能
     */
    @RequestMapping("/register")
    public int register(@RequestBody NewUser newUser, HttpSession session) {
        //通过用户输入的用户名查询是否存在数据  u代表查询回来的用户信息
        User u = mapper.selectByUsername(newUser.getUsername());
        JSONObject jsonObject = (JSONObject) session.getAttribute("code");
        if(jsonObject == null || jsonObject.isEmpty() || "null".equals(jsonObject)){
            return 4;
        }
        String memPhone = jsonObject.getString("memPhone");
        String code = jsonObject.getString("code");
        if (u != null) { //如果不为null 说明此用户名已存在
            return 3;//用户名已存在
        }else if (!newUser.getMem_phone().equals(memPhone) || !newUser.getVerify_code().equals(code)){
            return 2;//验证码错误
        }
        //用户名不存在 可以注册
        mapper.insert(newUser);
        session.removeAttribute("code");
        return 1;
    }

    @RequestMapping("/currentUser")
    public User currentUser(HttpSession session) {
        //获取登录成功时保存的用户对象
        return (User) session.getAttribute("user");
    }

    /*
        退出登录功能
     */
    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        //删除登录成功时保存的用户对象
        session.removeAttribute("user");
    }

    @RequestMapping("/isLogin")
    public int isLogin(HttpSession session){
        User u = (User) session.getAttribute("user");
        System.out.println(u);
        if (u==null){
            return 1;
        }else {
            return 2;
        }
    }

    @RequestMapping("/user/selectByidentity")
    public List<User> selectAdmin(){
        System.out.println(mapper.selectAdmin());
        return mapper.selectAdmin();
    }

    @RequestMapping("/user/updateIdentityByUserId")
    public int updateIdentity(@RequestBody User user){
        Integer identity = user.getIdentity();
        Integer userId = user.getUser_id();
        int i = mapper.updateIdentity(identity, userId);
        return i;
    }

    @RequestMapping("/user/delete")
    public int deleteUser(Integer userId){
        int i = mapper.deleteUuser(userId);
        return i;
    }

    @RequestMapping("/user/selectIdentity")
    public int selectIdentity(String username){
        System.out.println(mapper.selectIdentity(username));
        return mapper.selectIdentity(username);
    }



}
