package cn.bigcoder.demo.tcc.transaction.order;

import cn.bigcoder.demo.tcc.transaction.order.dto.ProductDto;

import java.util.List;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 * @description:
 **/
public interface ProductService {
    List<ProductDto> findByShopId(Long shopId);

    ProductDto findById(Long id);
}
