package com.tw.rule.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Getter
@Setter
@JsonTypeInfo(use = NAME ,property = "type", visible = true, include = EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DiscountCalculator.class, name = "DISCOUNT"),
        @JsonSubTypes.Type(value = MoneyOffCalculator.class, name = "MONEY_OFF")
})
public abstract class Calculator {
    private CalculatorType type;
    abstract Order calculate(Order order);
}
