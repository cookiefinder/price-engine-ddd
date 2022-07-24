package com.tw.rule.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CalculatedResult implements Comparable<CalculatedResult> {
    private BigDecimal amount;

    private CalculatedResult(BigDecimal amount) {
        this.amount = amount;
    }

    public static CalculatedResult of(BigDecimal amount) {
        return new CalculatedResult(amount);
    }

    @Override
    public int compareTo(CalculatedResult calculatedResult) {
        return amount.compareTo(calculatedResult.getAmount());
    }
}
