package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VideoMapper {
    //通过游戏id查询视视频
    @Select("select video.video_id,video.game_video from game,video where game.game_id=video.game_id and game.game_id = #{game_id}")
    Video selectByvId(int game_id);

    @Select("select * from video where game_id = #{gameId}")
    Video selectByGameId(Integer gameId);

    @Update("update video set game_video=#{video} where game_id = #{gameId}")
    void updateVideo(String video,Integer gameId);

    @Insert("insert into video values(null,#{game_id},#{game_video})")
    void insert(Video video);
}
