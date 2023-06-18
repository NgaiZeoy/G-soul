package cn.com.gamersoul.entity;

public class GameComment {
    private Integer comment_id;
    private Integer game_id;
    private Integer user_id;
    private  String nickname;
    private Integer parent_id;
    private String comment;
    private String urls;
    private Integer is_parent;

    @Override
    public String toString() {
        return "GameComment{" +
                "comment_id=" + comment_id +
                ", game_id=" + game_id +
                ", user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", parent_id=" + parent_id +
                ", comment='" + comment + '\'' +
                ", urls='" + urls + '\'' +
                ", is_parent=" + is_parent +
                '}';
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Integer getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(Integer is_parent) {
        this.is_parent = is_parent;
    }
}
