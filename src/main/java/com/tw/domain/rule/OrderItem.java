package com.tw.domain.rule;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderItem {
    private ProductSku sku;
    private BigDecimal price;
    private Long number;

    public BigDecimal getAmount() {
        return price.multiply(BigDecimal.valueOf(number));
    }
}
