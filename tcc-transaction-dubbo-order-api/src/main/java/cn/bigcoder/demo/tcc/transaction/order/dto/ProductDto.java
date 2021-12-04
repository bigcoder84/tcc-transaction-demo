package cn.bigcoder.demo.tcc.transaction.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 **/
public class ProductDto implements Serializable {
    private long productId;

    private long shopId;

    private String productName;

    private BigDecimal price;

    public ProductDto() {
    }

    public ProductDto(long productId, long shopId, String productName, BigDecimal price) {
        this.productId = productId;
        this.shopId = shopId;
        this.productName = productName;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
