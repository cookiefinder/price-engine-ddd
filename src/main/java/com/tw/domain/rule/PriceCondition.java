package com.tw.domain.rule;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class PriceCondition implements Condition {
    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    @Override
    public boolean applicable(Order order) {
        BigDecimal amount = order.getOrderAmount();
        return amount.compareTo(maxPrice) < 0 && amount.compareTo(minPrice) > 0;
    }
}