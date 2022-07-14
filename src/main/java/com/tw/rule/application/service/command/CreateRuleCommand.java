package com.tw.rule.application.service.command;

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
public class CreateRuleCommand {
    private String name;
    private String description;
    private RuleType ruleType;
    private Condition condition;
    private Calculator calculator;

    public Rule toRule() {
        return new Rule(name, description, ruleType, condition, calculator, true);
    }
}
