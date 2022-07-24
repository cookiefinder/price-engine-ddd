package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

import static com.tw.rule.domain.model.RuleType.PROMOTION;

@Getter
@AllArgsConstructor
public class Rule {
    private RuleId id;
    private PromotionCode code;
    private String name;
    private String description;
    private RuleType type;
    private Condition condition;
    private Calculator calculator;
    private Boolean active;

    private Rule(String name, String description, RuleType type, Condition condition, Calculator calculator, Boolean active) {
        this.id = new RuleId();
        this.code = Objects.equals(PROMOTION, type) ? PromotionCode.init() : null;
        this.name = name;
        this.description = description;
        this.type = type;
        this.condition = condition;
        this.calculator = calculator;
        this.active = active;
    }

    public static Rule init(String name, String description, RuleType type, Condition condition, Calculator calculator, Boolean active) {
        return new Rule(name, description, type, condition, calculator, active);
    }

    public boolean applicable(Order order) {
        return condition.applicable(order);
    }

    public CalculatedResult calculate(Order order) {
        return calculator.calculate(order);
    }
}
