package com.tw.domain.rule;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class MoneyOffCalculator implements Calculator {
    private BigDecimal amountLimit;
    private BigDecimal freeAmount;

    @Override
    public Order calculate(Order order) {
        BigDecimal amount = order.getTotalAmount();
        BigDecimal multiple = amount.divide(amountLimit, RoundingMode.FLOOR);
        BigDecimal discountedPrice = amount.subtract(freeAmount.multiply(multiple));
        order.discount(discountedPrice);
        return order;
    }
}