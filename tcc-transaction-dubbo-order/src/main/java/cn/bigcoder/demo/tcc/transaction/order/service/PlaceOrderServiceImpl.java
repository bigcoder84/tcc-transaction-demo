package cn.bigcoder.demo.tcc.transaction.order.service;

import cn.bigcoder.demo.tcc.transaction.order.PaymentService;
import cn.bigcoder.demo.tcc.transaction.order.PlaceOrderService;
import cn.bigcoder.demo.tcc.transaction.order.dto.OrderDto;
import cn.bigcoder.demo.tcc.transaction.order.entity.Order;
import cn.bigcoder.demo.tcc.transaction.order.entity.Shop;
import cn.bigcoder.demo.tcc.transaction.order.repository.ShopRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.mengyun.tcctransaction.CancellingException;
import org.mengyun.tcctransaction.ConfirmingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by changming.xie on 4/1/16.
 */
@DubboService
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    PaymentService paymentService;

    public String placeOrder(long payerUserId, long shopId, Map<Long, Integer> productQuantities, final BigDecimal redPacketPayAmount) {
        Shop shop = shopRepository.findById(shopId);

        OrderDto order = orderService.createOrder(payerUserId, shop.getOwnerUserId(), productQuantities);
        order.needToPay(redPacketPayAmount, order.getTotalAmount().subtract(redPacketPayAmount));
        orderService.update(order);

        try {

            paymentService.makePayment(order.getMerchantOrderNo());

        } catch (ConfirmingException confirmingException) {
            //exception throws with the tcc transaction status is CONFIRMING,
            //when tcc transaction is confirming status,
            // the tcc transaction recovery will try to confirm the whole transaction to ensure eventually consistent.
        } catch (CancellingException cancellingException) {
            //exception throws with the tcc transaction status is CANCELLING,
            //when tcc transaction is under CANCELLING status,
            // the tcc transaction recovery will try to cancel the whole transaction to ensure eventually consistent.
        } catch (Throwable e) {
            //other exceptions throws at TRYING stage.
            //you can retry or cancel the operation.
            e.printStackTrace();
        }

        return order.getMerchantOrderNo();
    }
}
