package cn.bigcoder.demo.tcc.transaction.order.factory;

import cn.bigcoder.demo.tcc.transaction.order.entity.Order;
import cn.bigcoder.demo.tcc.transaction.order.entity.OrderLine;
import cn.bigcoder.demo.tcc.transaction.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by changming.xie on 4/1/16.
 */
@Component
public class OrderFactory {

    @Autowired
    ProductRepository productRepository;

    public Order buildOrder(long payerUserId, long payeeUserId, Map<Long, Integer> productQuantities) {

        Order order = new Order(payerUserId, payeeUserId);

        for (Map.Entry<Long, Integer> pair : productQuantities.entrySet()) {
            long productId = pair.getKey();
            order.addOrderLine(new OrderLine(productId, pair.getValue(), productRepository.findById(productId).getPrice()));
        }

        return order;
    }
}
