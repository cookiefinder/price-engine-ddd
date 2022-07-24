package com.tw.rule.application.presentation;

import com.tw.rule.domain.model.CalculatedResult;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculationPresentation {
    private BigDecimal totalPrice;

    public static CalculationPresentation from(CalculatedResult result) {
        return new CalculationPresentation(result.getAmount());
    }
}
