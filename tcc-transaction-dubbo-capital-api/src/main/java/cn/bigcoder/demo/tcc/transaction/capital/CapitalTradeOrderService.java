package cn.bigcoder.demo.tcc.transaction.capital;

import org.mengyun.tcctransaction.api.EnableTcc;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface CapitalTradeOrderService {

    @EnableTcc
    String record(CapitalTradeOrderDto tradeOrderDto);

}
