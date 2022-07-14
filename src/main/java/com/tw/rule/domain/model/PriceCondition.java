package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class PriceCondition extends Condition {
    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    @Override
    public boolean applicable(Order order) {
        BigDecimal amount = order.getOrderAmount();
        return amount.compareTo(maxPrice) < 0 && amount.compareTo(minPrice) > 0;
    }
}