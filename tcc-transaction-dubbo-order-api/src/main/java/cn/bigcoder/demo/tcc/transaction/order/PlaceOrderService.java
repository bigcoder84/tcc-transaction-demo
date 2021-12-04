package cn.bigcoder.demo.tcc.transaction.order;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 * @description:
 **/
public interface PlaceOrderService {
    String placeOrder(long payerUserId, long shopId, Map<Long, Integer> productQuantities, final BigDecimal redPacketPayAmount);
}
