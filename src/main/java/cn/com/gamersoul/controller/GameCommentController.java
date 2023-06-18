package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.GameComment;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.vo.GameCommentVO;
import cn.com.gamersoul.mapper.GameCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GameCommentController {

    @Autowired(required = false)
    GameCommentMapper gameCommentMapper;

    @RequestMapping("/insert")
    public int insert(@RequestBody GameComment gameComment, HttpSession session){
        //System.out.println("gameComment = " + gameComment + ", session = " + session);
        User u = (User) session.getAttribute("user");
        if (u==null){//代表未登录
            return 2;
        }
        gameComment.setNickname(u.getNickname());
        gameComment.setUser_id(u.getUser_id());
        gameCommentMapper.insert(gameComment);
        return 1;
    }

    @RequestMapping("/comment/selectById")
    public List<GameComment> selectById(HttpSession session){
        User u = (User) session.getAttribute("user");
        Integer user_id = u.getUser_id();
        //System.out.println(gameCommentMapper.selectById(user_id));
        return gameCommentMapper.selectById(user_id);
    }

    @RequestMapping("/comment/selectGameById")
    public List<GameComment> selectGameById(Integer gameId, HttpSession session){
        //System.out.println("gameId = " + gameId);
        User u = (User) session.getAttribute("user");
        Integer user_id = u.getUser_id();
        //System.out.println("sdfsafdd"+gameCommentMapper.selectGameById(gameId,user_id));
        return gameCommentMapper.selectGameById(gameId,user_id);
    }

    @RequestMapping("/comment/selectByGameId")
    public List<GameCommentVO> selectCommentByGameId(Integer gameId) {
        List<GameCommentVO> gameCommentVOS = gameCommentMapper.selectCommentGameById(gameId);
        for (GameCommentVO gameCommentVO : gameCommentVOS) {
            Integer parentId = gameCommentVO.getComment_id();
            List<GameComment> gameComments = gameCommentMapper.gameComment(parentId);
            gameCommentVO.setGameComments(gameComments);
        }
        //System.out.println(gameCommentVOS);
        return gameCommentVOS;
    }



}
