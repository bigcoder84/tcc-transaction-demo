package cn.bigcoder.demo.tcc.transaction.order.dao;


import cn.bigcoder.demo.tcc.transaction.order.entity.Product;

import java.util.List;

/**
 * Created by twinkle.zhou on 16/11/10.
 */
public interface ProductDao {

    Product findById(long productId);

    List<Product> findByShopId(long shopId);
}
