package cn.bigcoder.demo.tcc.transaction.capital.repository;

import cn.bigcoder.demo.tcc.transaction.capital.dao.CapitalAccountDao;
import cn.bigcoder.demo.tcc.transaction.capital.entity.CapitalAccount;
import cn.bigcoder.demo.tcc.transaction.common.exception.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by changming.xie on 4/2/16.
 */
@Repository
public class CapitalAccountRepository {

    @Autowired
    CapitalAccountDao capitalAccountDao;

    public CapitalAccount findByUserId(long userId) {
        return capitalAccountDao.findByUserId(userId);
    }

    public void save(CapitalAccount capitalAccount) {
        int effectCount = capitalAccountDao.update(capitalAccount);
        if (effectCount < 1) {
            throw new InsufficientBalanceException();
        }
    }
}
