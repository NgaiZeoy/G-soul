package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.Video;
import cn.com.gamersoul.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 游戏视频控制器
 */
@RestController
public class VideoController {
    @Autowired(required = false)
    VideoMapper mapper;

    @RequestMapping("/video/selectByvId")
    public Video selectByvId(int gameId){
        /*System.out.println("gameId = " + gameId);
        System.out.println(mapper.selectByvId(gameId));*/
        return mapper.selectByvId(gameId);
    }

    @RequestMapping("/video/selectByGameId")
    public Video selectByGameId(Integer gameId){
        System.out.println("gamgfawe:"+mapper.selectByGameId(gameId));
        Video video = mapper.selectByGameId(gameId);
        return video;
    }

    @RequestMapping("/video/updateVideo")
    public void updateVideo(@RequestBody Video video){
        System.out.println("video = " + video);
        String gameVideo = video.getGame_video();
        Integer gameId = video.getGame_id();
        mapper.updateVideo(gameVideo,gameId);
    }

    @RequestMapping("/video/insert")
    public void insert(@RequestBody Video video){
        mapper.insert(video);
    }
}
