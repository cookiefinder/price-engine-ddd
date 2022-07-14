package com.tw.rule.domain.model;

import lombok.Getter;

import java.util.List;

@Getter
public class AndCondition extends Condition {
    private List<Condition> conditions;

    @Override
    public boolean applicable(Order order) {
        return conditions.stream().allMatch(condition -> condition.applicable(order));
    }
}
