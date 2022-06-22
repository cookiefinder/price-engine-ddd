package com.tw.domain.rule;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class ProductCondition implements Condition {
    private Set<ProductSku> allowedProductSkuSet;

    @Override
    public boolean applicable(Order order) {
        return order.getOrderItems().stream().anyMatch(item -> allowedProductSkuSet.contains(item.getSku()));
    }
}