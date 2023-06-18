package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.Game;
import cn.com.gamersoul.entity.Shopping;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.GameMapper;
import cn.com.gamersoul.vo.SpiltSearchVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏控制器
 */
@RestController
public class GameController {
    @Autowired(required = false)
    GameMapper mapper;

    //通过游戏ID查找游戏
    @RequestMapping("/game/selectById")
    public Game selectById(int gameId) {
        return mapper.selectById(gameId);
    }

    //通过分类id查游戏集合
    @RequestMapping("/game/selectBySortId")
    public List<Game> selectBySortId(int sortId) {

        return mapper.selectBySortId(sortId);
    }

    //通过分类分类id查游戏根据销量取前2个
    @RequestMapping({"/game/selectBySortIdInCount"})
    public List<Game> selectBySortIdInCount(int sortId) {
        /*System.out.println("sortId = " + sortId);
        System.out.println(mapper.selectBySortIdInCount(sortId));*/
        return mapper.selectBySortIdInCount(sortId);
    }


    @RequestMapping("/game/selectByStatus")
    public List<Game> selectByStatus(String status) {
        /*System.out.println(mapper.selectByStatus(status));*/
        return mapper.selectByStatus(status);
    }

    //输入框模糊查询
    @RequestMapping("/game/selectByName")
    public List<Game> selectByName(String name) {
        return mapper.selectByName(name);
    }

    //通过用户id查询购物车游戏
    @RequestMapping("/game/{userId:[0-9]+}")
    public List<Game> selectByUserId(@PathVariable Long userId) {
        return mapper.selectByUserId(userId);
    }

    //查询游戏通过销量排行取前2
    @RequestMapping("/game/select")
    public List<Game> select() {
        return mapper.select();
    }

    //通过用户购物车游戏表中的id删除对应的游戏
    @RequestMapping("/game/deleteById/{id:[0-9]+}")
    public void deleteById(@PathVariable Integer id) {
        //System.out.println(id);
        mapper.deleteById(id);
    }

    @GetMapping("game/selectBySortItem")
    public List<Game> selectBySortItem(String sortItem){
        return mapper.selectBySortItem(sortItem);
    }

    @RequestMapping("/userDetail/selectGameByUserId")
    public List<Game> selectGameByUserId(HttpSession session) {
        User u = (User) session.getAttribute("user");
        Integer userId = u.getUser_id();
        System.out.println(mapper.selectGameByUserId(userId));
        return mapper.selectGameByUserId(userId);
    }

    @RequestMapping("/friend/selectGameByUserId")
    public List<Game> selectGameByUserId(Integer userId){
        System.out.println("...userId = " + userId);
        return mapper.selectGameByUserId(userId);
    }

    @RequestMapping("/game/selectGame")
    public List<Game> selectGame(){
        return mapper.selectGame();
    }

    @RequestMapping("/game/delete")
    public int deleteGame(Integer gameId){
        int i = mapper.deleteGame(gameId);
        return i;
    }
    @RequestMapping("/game/updateTitle")
    public int updateTitleImg(Game game){
        Integer gameId = game.getGame_id();
        String gameTitle = game.getImg_title_url();
        int result = mapper.updateTitleImg(gameTitle, gameId);
        return result;
    }

    @RequestMapping("/game/updateByGameId")
    public int updateByGameId(@RequestBody Game game){
        System.out.println("game = " + game);
        Integer gameId = game.getGame_id();
        String name = game.getName();
        String content = game.getContent();
        Integer saleCount = game.getSale_count();
        String discount = game.getDiscount();
        Double curPrice = game.getCur_price();
        String oldPrice = game.getOld_price();
        String smallImgs = game.getSmall_imgs();
        String titleUrl = game.getImg_title_url();
        int result = mapper.updateByGameId(name, content, saleCount, discount, curPrice, oldPrice, titleUrl, smallImgs, gameId);
        return result;
    }

    @RequestMapping("/game/insert")
    public Integer insert(@RequestBody Game game){
        Integer result = mapper.insert(game);
        return result;
    }

    @RequestMapping("/game/selectByGameName")
    public Integer selectGameIdByGameName(String name){
        Integer integer = mapper.selectGameIdByGameName(name);
        return integer;
    }

    @GetMapping("/game/splitSearch")
    List<SpiltSearchVO> splitSearch(Integer param){
        List<SpiltSearchVO> games = new ArrayList<>();
        switch (param){
            case 1:
                games = mapper.hotSellingGames();//热销游戏
                break;
            case 2:
                games = mapper.newGames();//新品游戏
                break;
            case 3:
                games = mapper.discountGames();//优惠游戏
        }
        return games;
    }

}
