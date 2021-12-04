package cn.bigcoder.demo.tcc.transaction.capital;

import java.math.BigDecimal;

/**
 * Created by twinkle.zhou on 16/11/11.
 */
public interface CapitalAccountService {

    BigDecimal getCapitalAccountByUserId(long userId);
}
