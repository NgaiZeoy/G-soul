package cn.com.gamersoul.entity;

public class ReviewComment {
    private Integer id;
    private Integer comment_id;
    private Integer user_id;
    private Integer game_id;
    private String comment;
    private String nickname;

    @Override
    public String toString() {
        return "ReviewComment{" +
                "id=" + id +
                ", comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", game_id=" + game_id +
                ", comment='" + comment + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
