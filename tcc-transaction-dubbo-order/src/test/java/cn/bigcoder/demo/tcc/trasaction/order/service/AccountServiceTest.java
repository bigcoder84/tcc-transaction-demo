package cn.bigcoder.demo.tcc.trasaction.order.service;

import cn.bigcoder.demo.tcc.transaction.order.AccountService;
import cn.bigcoder.demo.tcc.trasaction.order.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
public class AccountServiceTest extends BaseTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testPlaceOrder() {
        accountService.getCapitalAccountByUserId(1);
    }
}
