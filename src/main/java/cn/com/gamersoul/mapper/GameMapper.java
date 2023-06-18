package cn.com.gamersoul.mapper;

import cn.com.gamersoul.entity.Game;

import cn.com.gamersoul.entity.Shopping;
import cn.com.gamersoul.vo.SpiltSearchVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameMapper {

    //通过游戏ID查找游戏
    @Select("select * from game where game_id= #{game_id}")
    Game selectById(int game_id);

    //通过游戏分类id查询游戏
    @Select("select game.game_id, game.name, game.content, game.sale_count, game.discount, game.old_price, game.cur_price, game.img_title_url,game.`status`,game.small_imgs,game.mid_img\n" +
            "from game,game_sort,sort\n" +
            "where game.game_id=game_sort.game_id \n" +
            "and sort.sort_id=game_sort.sort_id\n" +
            "and sort.sort_id = #{sort_id}\n")
    List<Game> selectBySortId(int sort_id);


    //通过分类分类id查游戏根据销量取前2个
    @Select("select game.game_id, game.name, game.content, game.sale_count, game.discount, game.old_price, game.cur_price, game.img_title_url,game.`status`,game.small_imgs,game.mid_img\n" +
            "from game,game_sort,sort\n" +
            "where game.game_id=game_sort.game_id \n" +
            "and sort.sort_id=game_sort.sort_id\n" +
            "and sort.sort_id = #{sort_id}  order by sale_count desc limit 0,2\n")
    List<Game> selectBySortIdInCount(int sortId);

    @Select("select game_id,name,cur_price,img_title_url,status,small_imgs from game where status='new'")
    List<Game> selectByStatus(String status);

    //输入框模糊查询
    @Select("select * from game where name like concat('%',#{wd},'%')")
    List<Game> selectByName(String name);

    //通过用户id查询购物车游戏
    @Select("SELECT game.game_id,img_title_url,`name`,cur_price,shopping_car.id\n" +
            "FROM user\n" +
            "LEFT JOIN shopping_car ON `user`.user_id=shopping_car.user_id\n" +
            "LEFT JOIN game ON shopping_car.game_id=game.game_id\n" +
            "WHERE `user`.user_id=#{userId}")
    List<Game> selectByUserId(Long userId);

    //查询游戏通过销量排行取前2
    @Select("select * from game ORDER BY sale_count desc LIMIT 0,2 ")
    List<Game> select();

    //通过游戏id删购物车游戏
    @Delete("delete from shopping_car where id=#{id}")
    void deleteById(Integer id);

    @Select("SELECT game.game_id,name,img_title_url,discount,old_price,cur_price,sale_count,small_imgs\n" +
            "FROM game\n" +
            "LEFT JOIN game_sort ON game.game_id=game_sort.game_id\n" +
            "LEFT JOIN sort ON game_sort.sort_id=sort.sort_id\n" +
            "WHERE sort_item=#{sort_item}")
    List<Game> selectBySortItem(String sort_item);
    //查询用户id查询用户购买的游戏
    @Select("SELECT game.game_id,game.`name`,game.img_title_url,game.cur_price \n" +
            "from user_game \n" +
            "LEFT JOIN game \n" +
            "on game.game_id=user_game.game_id \n" +
            "where user_game.user_id = #{userId}\n")
    List<Game> selectGameByUserId(Integer userId);


    @Delete("delete from game where game_id=#{gameId}")
    int deleteGame(Integer gameId);

    //查询所有游戏
    @Select("select * from game")
    List<Game> selectGame();

    @Update("update game set img_title_url = #{gameTitle} where game_id = #{gameId}")
    int updateTitleImg(String gameTitle,Integer gameId);

    @Update("update game set name = #{name},content=#{content},sale_count=#{saleCount},discount=#{discount}," +
            "cur_price=#{curPrice},old_price=#{oldPrice},img_title_url=#{titlePicUrl},small_imgs = #{smallImage} where game_id = #{gameId}")
    int updateByGameId(String name ,String content,Integer saleCount,String discount,Double curPrice,String oldPrice,
                       String titlePicUrl,String smallImage,Integer gameId );

    @Insert("insert into game values(null,#{name},#{content},#{sale_count},#{discount},#{old_price},#{cur_price},#{img_title_url},#{status},#{small_imgs},#{mid_img})")
    Integer insert(Game game);

    @Select("select game_id from game where name=#{name}")
    Integer selectGameIdByGameName(String name);

    //热销游戏
    @Select("SELECT game_id,img_title_url,`name`,discount,old_price,cur_price,small_imgs \n" +
            "FROM `game`\n" +
            "WHERE sale_count>500")
    List<SpiltSearchVO> hotSellingGames();

    //新品游戏
    @Select("SELECT game_id,img_title_url,`name`,discount,old_price,cur_price,small_imgs \n" +
            "FROM `game`\n" +
            "WHERE `status`='new'")
    List<SpiltSearchVO> newGames();

    //优惠游戏
    @Select("SELECT game_id,img_title_url,`name`,discount,old_price,cur_price,small_imgs \n" +
            "FROM `game`\n" +
            "WHERE discount!='无'")
    List<SpiltSearchVO> discountGames();
}

