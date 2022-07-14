package com.tw.rule.application.service.representation;

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
public class RuleRepresentation {
    private Long id;
    private String code;
    private String name;
    private String description;
    private RuleType type;
    private Condition condition;
    private Calculator calculator;
    private Boolean active;

    public static RuleRepresentation from(Rule rule) {
        return new RuleRepresentation(rule.getId().getId(),
                rule.getCode().getCode(),
                rule.getName(),
                rule.getDescription(),
                rule.getType(),
                rule.getCondition(),
                rule.getCalculator(),
                rule.getActive());
    }
}
