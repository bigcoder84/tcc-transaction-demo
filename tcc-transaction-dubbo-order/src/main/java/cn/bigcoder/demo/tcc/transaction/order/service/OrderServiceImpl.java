package cn.bigcoder.demo.tcc.transaction.order.service;

import cn.bigcoder.demo.tcc.transaction.order.OrderService;
import cn.bigcoder.demo.tcc.transaction.order.dto.OrderDto;
import cn.bigcoder.demo.tcc.transaction.order.dto.OrderLineDto;
import cn.bigcoder.demo.tcc.transaction.order.entity.Order;
import cn.bigcoder.demo.tcc.transaction.order.entity.OrderLine;
import cn.bigcoder.demo.tcc.transaction.order.factory.OrderFactory;
import cn.bigcoder.demo.tcc.transaction.order.repository.OrderRepository;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by changming.xie on 3/25/16.
 */
@DubboService
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderFactory orderFactory;

    @Transactional
    public OrderDto createOrder(long payerUserId, long payeeUserId, Map<Long, Integer> productQuantities) {
        Order order = orderFactory.buildOrder(payerUserId, payeeUserId, productQuantities);

        orderRepository.create(order);

        return buildOrderDto(order);
    }

    public void update(OrderDto order) {
        orderRepository.update(buildOrder(order));
    }


    public OrderDto findOrderByMerchantOrderNo(String orderNo) {
        return buildOrderDto(orderRepository.findByMerchantOrderNo(orderNo));
    }

    private OrderDto buildOrderDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setPayerUserId(order.getPayerUserId());
        orderDto.setPayeeUserId(order.getPayeeUserId());
        orderDto.setRedPacketPayAmount(order.getRedPacketPayAmount());
        orderDto.setCapitalPayAmount(order.getCapitalPayAmount());
        orderDto.setStatus(order.getStatus());
        orderDto.setMerchantOrderNo(order.getMerchantOrderNo());
        orderDto.setVersion(order.getVersion());
        if (CollectionUtils.isNotEmpty(order.getOrderLines())) {
            orderDto.setOrderLines(order.getOrderLines().stream().map(this::buildOrderLineDto).collect(Collectors.toList()));
        }
        return orderDto;
    }

    private OrderLineDto buildOrderLineDto(OrderLine orderLine) {
        if (orderLine == null) {
            return null;
        }
        OrderLineDto orderLineDto = new OrderLineDto();
        orderLineDto.setId(orderLine.getId());
        orderLineDto.setProductId(orderLine.getProductId());
        orderLineDto.setQuantity(orderLine.getQuantity());
        orderLineDto.setUnitPrice(orderLine.getUnitPrice());
        return orderLineDto;
    }

    private Order buildOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setPayerUserId(orderDto.getPayerUserId());
        order.setPayeeUserId(orderDto.getPayeeUserId());
        order.setRedPacketPayAmount(orderDto.getRedPacketPayAmount());
        order.setCapitalPayAmount(orderDto.getCapitalPayAmount());
        order.setStatus(orderDto.getStatus());
        order.setMerchantOrderNo(orderDto.getMerchantOrderNo());
        order.setVersion(orderDto.getVersion());
        if (CollectionUtils.isNotEmpty(orderDto.getOrderLines())) {
            order.setOrderLines(orderDto.getOrderLines().stream().map(this::buildOrderLine).collect(Collectors.toList()));
        }
        return order;
    }

    private OrderLine buildOrderLine(OrderLineDto orderLine) {
        if (orderLine == null) {
            return null;
        }
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setId(orderLine.getId());
        orderLine1.setProductId(orderLine.getProductId());
        orderLine1.setQuantity(orderLine.getQuantity());
        orderLine1.setUnitPrice(orderLine.getUnitPrice());
        return orderLine1;
    }

}
