package cn.bigcoder.demo.tcc.transaction.redpacket.dao;

import cn.bigcoder.demo.tcc.transaction.redpacket.entity.RedPacketAccount;

/**
 * Created by changming.xie on 4/2/16.
 */
public interface RedPacketAccountDao {

    RedPacketAccount findByUserId(long userId);

    int update(RedPacketAccount redPacketAccount);
}
