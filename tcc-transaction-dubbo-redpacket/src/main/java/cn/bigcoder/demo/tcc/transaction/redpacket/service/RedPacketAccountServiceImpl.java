package cn.bigcoder.demo.tcc.transaction.redpacket.service;

import cn.bigcoder.demo.tcc.transaction.redpacket.repository.RedPacketAccountRepository;
import cn.bigcoder.demo.tcc.trasaction.redpacket.RedPacketAccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
@DubboService
public class RedPacketAccountServiceImpl implements RedPacketAccountService {

    @Autowired
    RedPacketAccountRepository redPacketAccountRepository;

    @Override
    public BigDecimal getRedPacketAccountByUserId(long userId) {
        return redPacketAccountRepository.findByUserId(userId).getBalanceAmount();
    }
}
