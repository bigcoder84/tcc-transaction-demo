package cn.bigcoder.demo.tcc.trasaction.redpacket.reporsitory;

import cn.bigcoder.demo.tcc.transaction.redpacket.entity.RedPacketAccount;
import cn.bigcoder.demo.tcc.transaction.redpacket.repository.RedPacketAccountRepository;
import cn.bigcoder.demo.tcc.trasaction.redpacket.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
public class RedPacketAccountRepositoryTest extends BaseTest {

    @Autowired
    private RedPacketAccountRepository redPacketAccountRepository;

    @Test
    public void testQuery() {
        RedPacketAccount byUserId = redPacketAccountRepository.findByUserId(1);

    }
}
