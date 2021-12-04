package cn.bigcoder.demo.tcc.transaction.order.repository;


import cn.bigcoder.demo.tcc.transaction.order.dao.OrderDao;
import cn.bigcoder.demo.tcc.transaction.order.dao.OrderLineDao;
import cn.bigcoder.demo.tcc.transaction.order.entity.Order;
import cn.bigcoder.demo.tcc.transaction.order.entity.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

/**
 * Created by changming.xie on 4/1/16.
 */
@Repository
public class OrderRepository {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderLineDao orderLineDao;

    public void create(Order order) {
        orderDao.insert(order);

        for (OrderLine orderLine : order.getOrderLines()) {
            orderLineDao.insert(orderLine);
        }
    }

    public void update(Order order) {
        order.updateVersion();
        int effectCount = orderDao.update(order);

        if (effectCount < 1) {
            throw new OptimisticLockingFailureException("update order failed");
        }
    }

    public Order findByMerchantOrderNo(String merchantOrderNo) {
        return orderDao.findByMerchantOrderNo(merchantOrderNo);
    }
}
