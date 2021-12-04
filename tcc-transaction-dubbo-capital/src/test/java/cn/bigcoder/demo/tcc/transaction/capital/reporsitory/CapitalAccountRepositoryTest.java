package cn.bigcoder.demo.tcc.transaction.capital.reporsitory;

import cn.bigcoder.demo.tcc.transaction.capital.BaseTest;
import cn.bigcoder.demo.tcc.transaction.capital.entity.CapitalAccount;
import cn.bigcoder.demo.tcc.transaction.capital.repository.CapitalAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
@Slf4j
public class CapitalAccountRepositoryTest extends BaseTest {
    @Autowired
    private CapitalAccountRepository capitalAccountRepository;

    @Test
    public void testInsert() {
        CapitalAccount byUserId = capitalAccountRepository.findByUserId(1);
        log.info("123:{}", byUserId);
    }

}
