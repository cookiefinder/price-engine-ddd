package com.tw.rule.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {
    private ProductSku productSku;
    private BigDecimal price;

    private Product(ProductSku productSku, BigDecimal price) {
        this.productSku = productSku;
        this.price = price;
    }

    public static Product from(ProductSku productSku, BigDecimal price) {
        return new Product(productSku, price);
    }
}
