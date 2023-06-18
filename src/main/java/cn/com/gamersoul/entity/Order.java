package cn.com.gamersoul.entity;
 
import lombok.Data;
 
import java.math.BigDecimal;
 
/**
 *  发起支付时的参数
 * */
@Data
public class Order {
    //订单号
    private String order_no;
    //订单名称
    private String order_name;
    //总金额
    private BigDecimal order_total = BigDecimal.ZERO;



    @Override
    public String toString() {
        return "Order{" +
                "order_no=" + order_no +
                ", order_name='" + order_name + '\'' +
                ", order_total=" + order_total +
                '}';
    }
}