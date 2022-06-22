package com.tw.domain.rule;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class DiscountCalculator implements Calculator {
    private BigDecimal discount;

    @Override
    public Order calculate(Order order) {
        BigDecimal discountedPrice = order.getTotalAmount().multiply(discount);
        order.discount(discountedPrice);
        return order;
    }
}
