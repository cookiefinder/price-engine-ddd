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

    public Rule(String name, String description, RuleType type, Condition condition, Calculator calculator, Boolean active) {
        this.id = new RuleId();
        this.code = Objects.equals(PROMOTION, type) ? new PromotionCode() : null;
        this.name = name;
        this.description = description;
        this.type = type;
        this.condition = condition;
        this.calculator = calculator;
        this.active = active;
    }
}
