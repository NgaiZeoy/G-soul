package cn.com.gamersoul.entity;

/**
 * 游戏视频类
 */
public class Video {
    private Integer video_id;
    private Integer game_id;
    private String game_video;

    @Override
    public String toString() {
        return "Video{" +
                "video_id=" + video_id +
                ", game_id=" + game_id +
                ", game_video='" + game_video + '\'' +
                '}';
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getGame_video() {
        return game_video;
    }

    public void setGame_video(String game_video) {
        this.game_video = game_video;
    }
}
