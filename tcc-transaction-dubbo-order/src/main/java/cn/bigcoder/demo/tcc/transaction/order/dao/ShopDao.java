package cn.bigcoder.demo.tcc.transaction.order.dao;


import cn.bigcoder.demo.tcc.transaction.order.entity.Shop;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface ShopDao {
    Shop findById(long id);
}
