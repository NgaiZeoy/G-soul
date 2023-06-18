package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Explain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExplainMapper {

    @Select("select game_explain.explain_id,game_explain.headline,game_explain.content from game,game_explain where game.game_id=game_explain.game_id and game.game_id=#{game_di}")
    List<Explain> selectByeId(int game_id);

}
