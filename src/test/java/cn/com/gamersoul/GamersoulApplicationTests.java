package cn.com.gamersoul;

import cn.com.gamersoul.mapper.GameMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GamersoulApplicationTests {

    @Autowired
    GameMapper mapper;
    @Test
    void contextLoads() {
    }

//    @Test
//    void select(){
//        int id = 4;
//        System.out.println(mapper.selectByUserId(id));
//    }
}
