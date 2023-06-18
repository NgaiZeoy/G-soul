package cn.com.gamersoul.controller;

import cn.com.gamersoul.dto.SortItemDTO;
import cn.com.gamersoul.entity.Label;
import cn.com.gamersoul.entity.Sort;
import cn.com.gamersoul.entity.SortTitle;
import cn.com.gamersoul.mapper.SortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SortController {
    @Autowired(required = false)
    SortMapper mapper;

    @RequestMapping("/sort/selectBygId")
    public List<Label> selectBysId(int gameId) {
        return mapper.selectBysId(gameId);
    }

    @RequestMapping("/sort/selectById")
    public Label selectById(int sortId) {
        return mapper.selectById(sortId);
    }

    @RequestMapping("/sort/selectItemByTitle")
    public List<Sort> selectItemByTitle(String title){
        System.out.println(mapper.selectItemByTitle(title));
        return mapper.selectItemByTitle(title);
    }

    @RequestMapping("/sort/insert")
    public int insert(@RequestBody Sort sort){
        int result = mapper.insert(sort);
        return result;
    }

    @RequestMapping("/sort/delete")
    public void deleteSort( @RequestBody Sort sort){
        System.out.println("sort = " + sort);
        String sort_title = sort.getSort_title();
        String sort_item = sort.getSort_item();
        mapper.deleteSort(sort_title,sort_item);
    }

    @RequestMapping("/gameSort/update")
    public void updateGameSort(SortItemDTO sortItemDTO){
        List<Integer> list = sortItemDTO.getList();
        System.out.println("sortItemDTO = " + sortItemDTO);
        Integer gameId = sortItemDTO.getGame_id();
        int result = mapper.deleteGameSortByGameId(gameId);
        if (result>0){
            for (Integer integer : list) {
                 mapper.updateGameSortDoInsert(gameId, integer);
            }
        }
    }

    @RequestMapping("/sort/selectByGameId")
    public List<String> selectItemByGameId(Integer gameId){
        System.out.println("数据为:"+mapper.selectItemByGameId(gameId));
        return mapper.selectItemByGameId(gameId);
    }

    @RequestMapping("/gameSort/insert")
    public void insert(SortItemDTO sortItemDTO){
        System.out.println("sortItemDTO = " + sortItemDTO);
        List<Integer> list = sortItemDTO.getList();
        Integer gameId = sortItemDTO.getGame_id();
        for (Integer integer : list) {
            mapper.updateGameSortDoInsert(gameId, integer);
        }
    }



}
