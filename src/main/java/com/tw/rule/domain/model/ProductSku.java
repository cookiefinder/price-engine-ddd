package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ProductSku {
    private String sku;

    public static ProductSku of(String sku) {
        return new ProductSku(sku);
    }
}
