package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCalculator extends Calculator {
    private BigDecimal discount;

    @Override
    public CalculatedResult calculate(Order order) {
        return CalculatedResult.of(order.getOriginalAmount().multiply(discount));
    }
}
