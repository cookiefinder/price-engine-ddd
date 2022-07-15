package com.tw.rule.application.presentation;

import com.tw.rule.domain.model.Calculator;
import com.tw.rule.domain.model.Condition;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.model.RuleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RulePresentation {
    private Long id;
    private String code;
    private String name;
    private String description;
    private RuleType type;
    private Condition condition;
    private Calculator calculator;
    private Boolean active;

    public static RulePresentation from(Rule rule) {
        return new RulePresentation(rule.getId().getId(),
                rule.getCode().getCode(),
                rule.getName(),
                rule.getDescription(),
                rule.getType(),
                rule.getCondition(),
                rule.getCalculator(),
                rule.getActive());
    }
}
