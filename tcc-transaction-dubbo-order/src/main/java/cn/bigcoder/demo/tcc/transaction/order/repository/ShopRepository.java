package cn.bigcoder.demo.tcc.transaction.order.repository;

import cn.bigcoder.demo.tcc.transaction.order.dao.ShopDao;
import cn.bigcoder.demo.tcc.transaction.order.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by changming.xie on 4/1/16.
 */
@Repository
public class ShopRepository {

    @Autowired
    ShopDao shopDao;

    public Shop findById(long id) {

        return shopDao.findById(id);
    }
}
