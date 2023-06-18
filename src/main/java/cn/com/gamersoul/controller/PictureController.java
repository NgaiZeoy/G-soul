package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.Picture;
import cn.com.gamersoul.mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 游戏图片控制器
 */
@RestController
public class PictureController {
    @Autowired(required =false)
    PictureMapper mapper;

    @RequestMapping("/img/selectBygId")
    public List<Picture> selectBygId(int gameId){
        /*System.out.println(mapper.selectBygId(gameId));
        System.out.println("gameId = " + gameId);*/
        return mapper.selectBygId(gameId);
    }
}
