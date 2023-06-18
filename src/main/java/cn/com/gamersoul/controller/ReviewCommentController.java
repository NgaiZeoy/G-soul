package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.ReviewComment;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.ReviewCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ReviewCommentController {

    @Autowired(required = false)
    ReviewCommentMapper reviewCommentMapper;

    @RequestMapping("/review/insert")
    public int insert(@RequestBody ReviewComment reviewComment, HttpSession session){
        User u = (User) session.getAttribute("user");
        if (u==null){//代表未登录
            return 2;
        }
        reviewComment.setUser_id(u.getUser_id());
        reviewComment.setNickname(u.getNickname());
        reviewCommentMapper.reviewInsert(reviewComment);
        return 1;
    }

    @RequestMapping("/reviewComment/selectByCommentId")
    public List<ReviewComment> selectByCommentId(Integer commentId){
        //System.out.println("commentId = " + commentId);
        //System.out.println(reviewCommentMapper.selectByCommentId(commentId));
        return reviewCommentMapper.selectByCommentId(commentId);
    }
}
