package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Shopping;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShoppingMapper {

    @Insert("insert into shopping_car values(null,#{user_id},#{game_id})")
    int insertByShop(Shopping shop);

    //根据游戏id删除用户购物车对应的游戏
    @Delete("DELETE FROM shopping_car WHERE id=#{id}")
    int deleteUserShoppingCarInfo(Integer id);

    @Select("select * from shopping_car where user_id=#{userId} and game_id = #{gameId}")
    Shopping selectShopping(Integer userId, Integer gameId);

    //根据用户id，游戏id，查询对应数据的id
    @Select("SELECT id FROM shopping_car WHERE user_id=#{user_id} AND game_id=#{game_id}")
    Integer selectIdtByUserIdAndGameId(Integer user_id,Integer game_id);

}
