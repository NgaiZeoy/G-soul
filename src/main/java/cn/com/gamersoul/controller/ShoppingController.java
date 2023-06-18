package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.Shopping;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ShoppingController {

    @Autowired(required = false)
    ShoppingMapper mapper;

    @RequestMapping("/shop/insertByShop")
    public int insertByShop(Integer gameId, HttpSession session){
        User u = (User) session.getAttribute("user");
        if (u==null){
            return 1;
        }else{
            Shopping shop = mapper.selectShopping(u.getUser_id(), gameId);
            if (shop==null){
                Shopping shopping = new Shopping();
                shopping.setGame_id(gameId);
                shopping.setUser_id(u.getUser_id());
                mapper.insertByShop(shopping);
                return 2;
            }
        }
        return 3;
    }




}
