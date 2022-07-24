package com.tw.rule.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class MoneyOffCalculator extends Calculator {
    private BigDecimal amountLimit;
    private BigDecimal freeAmount;

    @Override
    public CalculatedResult calculate(Order order) {
        BigDecimal amount = order.getOriginalAmount();
        BigDecimal multiple = amount.divide(amountLimit, RoundingMode.FLOOR);
        BigDecimal discountedPrice = amount.subtract(freeAmount.multiply(multiple));
        return CalculatedResult.of(discountedPrice);
    }
}