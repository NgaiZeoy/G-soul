package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PictureMapper {


    //通过游戏id查询小图片
    @Select("select image.img_id,image.game_image_url from game,image where game.game_id=image.game_id and game.game_id = #{game_id}")
    //select image.game_image_url from game,image where game.game_id=image.game_id and game.game_id = 1;
    List<Picture> selectBygId(int game_id);
}
