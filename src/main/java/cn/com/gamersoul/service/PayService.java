package cn.com.gamersoul.service;

import cn.com.gamersoul.entity.Order;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PayService {
    @Value("${alipay.returnUrl}")
    private String returnUrl;

    public Object pay(Order order) throws Exception {
        AlipayTradePagePayResponse response = Factory.Payment.Page().pay(order.getOrder_name(), order.getOrder_no(), order.getOrder_total().toString(), returnUrl);
        return response.body;
    }
}
