package cn.bigcoder.demo.tcc.transaction.redpacket.dao;


import cn.bigcoder.demo.tcc.transaction.redpacket.entity.TradeOrder;

/**
 * Created by twinkle.zhou on 16/11/14.
 */
public interface TradeOrderDao {

    void insert(TradeOrder tradeOrder);

    int update(TradeOrder tradeOrder);

    TradeOrder findByMerchantOrderNo(String merchantOrderNo);
}
