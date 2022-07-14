package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ProductCondition extends Condition {
    private Set<ProductSku> allowedProductSkuSet;

    @Override
    public boolean applicable(Order order) {
        return order.getOrderItems().stream().anyMatch(item -> allowedProductSkuSet.contains(item.getSku()));
    }
}