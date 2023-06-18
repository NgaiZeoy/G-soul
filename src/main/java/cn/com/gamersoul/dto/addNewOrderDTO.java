package cn.com.gamersoul.dto;

import cn.com.gamersoul.entity.Game;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class addNewOrderDTO {

    //总金额
    private Integer aggregate;
    //订单中的游戏
    private String[] checkList;
}
