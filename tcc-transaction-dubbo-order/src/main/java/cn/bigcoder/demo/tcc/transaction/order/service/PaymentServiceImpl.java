package cn.bigcoder.demo.tcc.transaction.order.service;

import cn.bigcoder.demo.tcc.transaction.capital.CapitalTradeOrderDto;
import cn.bigcoder.demo.tcc.transaction.capital.CapitalTradeOrderService;
import cn.bigcoder.demo.tcc.transaction.order.PaymentService;
import cn.bigcoder.demo.tcc.transaction.order.entity.Order;
import cn.bigcoder.demo.tcc.transaction.order.repository.OrderRepository;
import cn.bigcoder.demo.tcc.trasaction.redpacket.RedPacketTradeOrderService;
import cn.bigcoder.demo.tcc.trasaction.redpacket.dto.RedPacketTradeOrderDto;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.UniqueIdentity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

/**
 * Created by changming.xie on 4/1/16.
 */
@DubboService(timeout = 5000)
public class PaymentServiceImpl implements PaymentService {

    @DubboReference
    CapitalTradeOrderService capitalTradeOrderService;

    @DubboReference
    RedPacketTradeOrderService redPacketTradeOrderService;

    @Autowired
    OrderRepository orderRepository;

    @Compensable(confirmMethod = "confirmMakePayment", cancelMethod = "cancelMakePayment", asyncConfirm = false)
    public void makePayment(@UniqueIdentity String orderNo) {
        System.out.println("order try make payment called.time seq:" + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));

        Order order = orderRepository.findByMerchantOrderNo(orderNo);

        String result = capitalTradeOrderService.record(buildCapitalTradeOrderDto(order));
        String result2 = redPacketTradeOrderService.record(buildRedPacketTradeOrderDto(order));
    }

    public void confirmMakePayment(String orderNo) {

        System.out.println("order confirm make payment called. time seq:" + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));

        Order foundOrder = orderRepository.findByMerchantOrderNo(orderNo);

        //check if the trade order status is PAYING, if no, means another call confirmMakePayment happened, return directly, ensure idempotency.
        if (foundOrder != null) {
            foundOrder.confirm();
            orderRepository.update(foundOrder);
        }
    }

    public void cancelMakePayment(String orderNo) {

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("order cancel make payment called.time seq:" + DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));

        Order foundOrder = orderRepository.findByMerchantOrderNo(orderNo);

        //check if the trade order status is PAYING, if no, means another call cancelMakePayment happened, return directly, ensure idempotency.
        if (foundOrder != null) {
            foundOrder.cancelPayment();
            orderRepository.update(foundOrder);
        }
    }


    private CapitalTradeOrderDto buildCapitalTradeOrderDto(Order order) {

        CapitalTradeOrderDto tradeOrderDto = new CapitalTradeOrderDto();
        tradeOrderDto.setAmount(order.getCapitalPayAmount());
        tradeOrderDto.setMerchantOrderNo(order.getMerchantOrderNo());
        tradeOrderDto.setSelfUserId(order.getPayerUserId());
        tradeOrderDto.setOppositeUserId(order.getPayeeUserId());
        tradeOrderDto.setOrderTitle(String.format("order no:%s", order.getMerchantOrderNo()));

        return tradeOrderDto;
    }

    private RedPacketTradeOrderDto buildRedPacketTradeOrderDto(Order order) {
        RedPacketTradeOrderDto tradeOrderDto = new RedPacketTradeOrderDto();
        tradeOrderDto.setAmount(order.getRedPacketPayAmount());
        tradeOrderDto.setMerchantOrderNo(order.getMerchantOrderNo());
        tradeOrderDto.setSelfUserId(order.getPayerUserId());
        tradeOrderDto.setOppositeUserId(order.getPayeeUserId());
        tradeOrderDto.setOrderTitle(String.format("order no:%s", order.getMerchantOrderNo()));

        return tradeOrderDto;
    }
}
