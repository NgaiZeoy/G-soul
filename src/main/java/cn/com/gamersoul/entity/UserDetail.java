package cn.com.gamersoul.entity;

public class UserDetail {
    private Integer detail_id;
    private Integer user_id;
    private String nickname;
    private Integer grade;
    private String nation_img_url;
    private String nation;
    private String user_avatar_url;
    private String signature;

    public Integer getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Integer detail_id) {
        this.detail_id = detail_id;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getNation_img_url() {
        return nation_img_url;
    }

    public void setNation_img_url(String nation_img_url) {
        this.nation_img_url = nation_img_url;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getUser_avatar_url() {
        return user_avatar_url;
    }

    public void setUser_avatar_url(String user_avatar_url) {
        this.user_avatar_url = user_avatar_url;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "detail_id=" + detail_id +
                ", user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", grade=" + grade +
                ", nation_img_url='" + nation_img_url + '\'' +
                ", nation='" + nation + '\'' +
                ", user_avatar_url='" + user_avatar_url + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
