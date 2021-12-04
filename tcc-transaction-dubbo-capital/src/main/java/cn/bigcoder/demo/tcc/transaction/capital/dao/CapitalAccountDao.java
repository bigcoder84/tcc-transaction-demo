package cn.bigcoder.demo.tcc.transaction.capital.dao;


import cn.bigcoder.demo.tcc.transaction.capital.entity.CapitalAccount;

/**
 * Created by changming.xie on 4/2/16.
 */
public interface CapitalAccountDao {

    CapitalAccount findByUserId(long userId);

    int update(CapitalAccount capitalAccount);
}
