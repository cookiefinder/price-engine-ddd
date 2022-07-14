package com.tw.rule.resource.rest;

import com.tw.rule.application.service.RuleApplicationService;
import com.tw.rule.application.service.command.CreateRuleCommand;
import com.tw.rule.application.service.representation.RuleRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
public class RuleResource {
    private final RuleApplicationService ruleApplicationService;

    @PostMapping
    public RuleRepresentation createRule(@RequestBody CreateRuleCommand command) {
        return ruleApplicationService.createRule(command);
    }

    @GetMapping("/{id}")
    public RuleRepresentation getRuleDetail(@PathVariable Long id) {
        return ruleApplicationService.getRuleDetail(id);
    }
}
