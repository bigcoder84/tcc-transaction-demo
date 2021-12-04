package cn.bigcoder.demo.tcc.transaction.capital.service;

import cn.bigcoder.demo.tcc.transaction.capital.CapitalAccountService;
import cn.bigcoder.demo.tcc.transaction.capital.repository.CapitalAccountRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@DubboService
public class CapitalAccountServiceImpl implements CapitalAccountService {

    @Autowired
    CapitalAccountRepository capitalAccountRepository;

    @Override
    public BigDecimal getCapitalAccountByUserId(long userId) {
        return capitalAccountRepository.findByUserId(userId).getBalanceAmount();
    }
}
