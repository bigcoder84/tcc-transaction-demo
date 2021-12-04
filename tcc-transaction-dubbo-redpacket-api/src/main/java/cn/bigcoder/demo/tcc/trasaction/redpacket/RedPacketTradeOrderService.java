package cn.bigcoder.demo.tcc.trasaction.redpacket;

import cn.bigcoder.demo.tcc.trasaction.redpacket.dto.RedPacketTradeOrderDto;
import org.mengyun.tcctransaction.api.EnableTcc;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface RedPacketTradeOrderService {

    @EnableTcc
    String record(RedPacketTradeOrderDto tradeOrderDto);
}
