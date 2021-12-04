package cn.bigcoder.demo.tcc.transaction.order.service;

import cn.bigcoder.demo.tcc.transaction.order.ProductService;
import cn.bigcoder.demo.tcc.transaction.order.dto.ProductDto;
import cn.bigcoder.demo.tcc.transaction.order.entity.Product;
import cn.bigcoder.demo.tcc.transaction.order.repository.ProductRepository;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
@DubboService
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> findByShopId(Long shopId) {
        List<Product> products = productRepository.findByShopId(shopId);
        return products.stream().map(this::buildProductDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        return buildProductDto(productRepository.findById(id));
    }

    private ProductDto buildProductDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setShopId(product.getShopId());
        productDto.setProductName(product.getProductName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
