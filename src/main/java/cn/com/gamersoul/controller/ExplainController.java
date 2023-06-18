package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.Explain;
import cn.com.gamersoul.mapper.ExplainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class ExplainController {
    @Autowired(required = false)
    ExplainMapper mapper;

    @RequestMapping("/explain/selectByeId")
    public List<Explain> selectByeId(int gameId){
        /*System.out.println("gameId = " + gameId);
        System.out.println(mapper.selectByeId(gameId));*/
        return mapper.selectByeId(gameId);

    }
}
