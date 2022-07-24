package com.tw.rule.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderItem {
    private ProductSku sku;
    private BigDecimal price;
    private Long number;

    private OrderItem(ProductSku sku, BigDecimal price, Long number) {
        this.sku = sku;
        this.price = price;
        this.number = number;
    }

    public static OrderItem init(ProductSku sku, BigDecimal price, Long number) {
        return new OrderItem(sku, price, number);
    }

    public BigDecimal getAmount() {
        return price.multiply(BigDecimal.valueOf(number));
    }
}
