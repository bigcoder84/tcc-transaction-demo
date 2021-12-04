package cn.bigcoder.demo.tcc.transaction.web.vo;


import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

/**
 * Created by changming.xie on 4/2/16.
 */
public class PlaceOrderRequest {

    private long payerUserId;

    private long shopId;

    private BigDecimal redPacketPayAmount;

    private Map<Long, Integer> productQuantities = Maps.newHashMap();

    public long getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(long payerUserId) {
        this.payerUserId = payerUserId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getRedPacketPayAmount() {
        return redPacketPayAmount;
    }

    public void setRedPacketPayAmount(BigDecimal redPacketPayAmount) {
        this.redPacketPayAmount = redPacketPayAmount;
    }

    public Map<Long, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }
}
