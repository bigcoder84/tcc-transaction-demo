package cn.bigcoder.demo.tcc.transaction.order;

import java.math.BigDecimal;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
public interface AccountService {
    BigDecimal getRedPacketAccountByUserId(long userId);

    BigDecimal getCapitalAccountByUserId(long userId);
}
