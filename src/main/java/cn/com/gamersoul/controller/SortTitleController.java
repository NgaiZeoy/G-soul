package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.SortTitle;
import cn.com.gamersoul.mapper.SortTitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SortTitleController {

    @Autowired
    private SortTitleMapper sortTitleMapper;

    @RequestMapping("/sortTitle/select")
    public List<SortTitle> selectSort(){
        return sortTitleMapper.selectSortTitle();
    }

    @RequestMapping("/sortTitle/insert")
    public void insertSortTitle(String title){
        System.out.println("title = " + title);
        sortTitleMapper.insertSortTitle(title);
    }
}
