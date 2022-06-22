package com.tw.domain.rule;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Rule {
    private RuleId id;
    private PromotionCode code;
    private String name;
    private String description;
    private RuleType type;
    private List<Condition> conditions;
    private List<Calculator> calculators;

    public boolean applicable(Order order) {
        return conditions.stream().allMatch(condition -> condition.applicable(order));
    }

    public Order calculate(Order order) {
        for (Calculator calculator : calculators) {
            order = calculator.calculate(order);
        }
        return order;
    }
}
