package cn.com.gamersoul.entity;

/**
 * 游戏说明类
 */
public class Explain {
    private Integer explain_id;
    private Integer game_id;
    private String headline;
    private String content;

    @Override
    public String toString() {
        return "Explain{" +
                "explain_id=" + explain_id +
                ", game_id=" + game_id +
                ", headline='" + headline + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getExplain_id() {
        return explain_id;
    }

    public void setExplain_id(Integer explain_id) {
        this.explain_id = explain_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
