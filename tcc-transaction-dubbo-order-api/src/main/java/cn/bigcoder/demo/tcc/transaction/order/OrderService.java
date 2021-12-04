package cn.bigcoder.demo.tcc.transaction.order;

import cn.bigcoder.demo.tcc.transaction.order.dto.OrderDto;

import java.util.Map;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
public interface OrderService {
    OrderDto createOrder(long payerUserId, long payeeUserId, Map<Long, Integer> productQuantities);

    void update(OrderDto order);
    OrderDto findOrderByMerchantOrderNo(String orderNo);
}
