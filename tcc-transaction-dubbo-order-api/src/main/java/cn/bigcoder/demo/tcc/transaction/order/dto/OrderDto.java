package cn.bigcoder.demo.tcc.transaction.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by changming.xie on 3/25/16.
 */
public class OrderDto implements Serializable {

    private static final long serialVersionUID = -5908730245224893590L;
    private long id;

    private long payerUserId;

    private long payeeUserId;

    private BigDecimal redPacketPayAmount;

    private BigDecimal capitalPayAmount;

    private String status = "DRAFT";

    private String merchantOrderNo;

    private long version = 1l;

    private List<OrderLineDto> orderLines = new ArrayList<OrderLineDto>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(long payerUserId) {
        this.payerUserId = payerUserId;
    }

    public long getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(long payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public BigDecimal getRedPacketPayAmount() {
        return redPacketPayAmount;
    }

    public void setRedPacketPayAmount(BigDecimal redPacketPayAmount) {
        this.redPacketPayAmount = redPacketPayAmount;
    }

    public BigDecimal getCapitalPayAmount() {
        return capitalPayAmount;
    }

    public void setCapitalPayAmount(BigDecimal capitalPayAmount) {
        this.capitalPayAmount = capitalPayAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<OrderLineDto> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDto> orderLines) {
        this.orderLines = orderLines;
    }

    public void needToPay(BigDecimal redPacketPayAmount, BigDecimal capitalPayAmount) {
        this.redPacketPayAmount = redPacketPayAmount;
        this.capitalPayAmount = capitalPayAmount;
    }

    public BigDecimal getTotalAmount() {

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderLineDto orderLine : orderLines) {

            totalAmount = totalAmount.add(orderLine.getTotalAmount());
        }
        return totalAmount;
    }
}
