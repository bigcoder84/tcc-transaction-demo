package cn.bigcoder.demo.tcc.transaction.redpacket.repository;


import cn.bigcoder.demo.tcc.transaction.common.exception.InsufficientBalanceException;
import cn.bigcoder.demo.tcc.transaction.redpacket.dao.RedPacketAccountDao;
import cn.bigcoder.demo.tcc.transaction.redpacket.entity.RedPacketAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by changming.xie on 4/2/16.
 */
@Repository
public class RedPacketAccountRepository {

    @Autowired
    RedPacketAccountDao redPacketAccountDao;

    public RedPacketAccount findByUserId(long userId) {

        return redPacketAccountDao.findByUserId(userId);
    }

    public void save(RedPacketAccount redPacketAccount) {
        int effectCount = redPacketAccountDao.update(redPacketAccount);
        if (effectCount < 1) {
            throw new InsufficientBalanceException();
        }
    }
}
