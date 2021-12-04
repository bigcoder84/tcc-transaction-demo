package cn.bigcoder.demo.tcc.transaction.order.service;

import cn.bigcoder.demo.tcc.transaction.capital.CapitalAccountService;
import cn.bigcoder.demo.tcc.transaction.order.AccountService;
import cn.bigcoder.demo.tcc.trasaction.redpacket.RedPacketAccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
@DubboService
public class AccountServiceImpl implements AccountService {

    @DubboReference
    RedPacketAccountService redPacketAccountService;

    @DubboReference
    CapitalAccountService capitalAccountService;


    public BigDecimal getRedPacketAccountByUserId(long userId) {
        return redPacketAccountService.getRedPacketAccountByUserId(userId);
    }

    public BigDecimal getCapitalAccountByUserId(long userId) {
        return capitalAccountService.getCapitalAccountByUserId(userId);
    }
}
