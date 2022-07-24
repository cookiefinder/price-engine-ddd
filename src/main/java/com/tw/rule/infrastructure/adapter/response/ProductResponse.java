package com.tw.rule.infrastructure.adapter.response;

import com.tw.rule.domain.model.Product;
import com.tw.rule.domain.model.ProductSku;

import java.math.BigDecimal;

public class ProductResponse {
    private String sku;
    private BigDecimal price;

    public Product toProduct() {
        return Product.from(ProductSku.of(sku), price);
    }
}
