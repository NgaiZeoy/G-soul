package cn.com.gamersoul.vo;

import cn.com.gamersoul.entity.GameComment;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GameCommentVO implements Serializable {
    private Integer comment_id;
    private Integer game_id;
    private Integer user_id;
    private  String nickname;
    private Integer parent_id;
    private String comment;
    private String urls;
    private Integer is_parent;
    private List<GameComment> gameComments;

    @Override
    public String toString() {
        return "GameCommentVO{" +
                "comment_id=" + comment_id +
                ", game_id=" + game_id +
                ", user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", parent_id=" + parent_id +
                ", comment='" + comment + '\'' +
                ", urls='" + urls + '\'' +
                ", is_parent=" + is_parent +
                ", gameComments=" + gameComments +
                '}';
    }


}
