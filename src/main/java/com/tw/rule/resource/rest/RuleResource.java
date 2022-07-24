package com.tw.rule.resource.rest;

import com.tw.rule.application.command.CalculateOrderCommand;
import com.tw.rule.application.presentation.CalculationPresentation;
import com.tw.rule.application.service.RuleApplicationService;
import com.tw.rule.application.command.CreateRuleCommand;
import com.tw.rule.application.presentation.RulePagePresentation;
import com.tw.rule.application.presentation.RulePresentation;
import com.tw.rule.domain.exception.NotApplicableRule;
import com.tw.rule.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
public class RuleResource {
    private final RuleApplicationService ruleApplicationService;

    @GetMapping
    public RulePagePresentation getRulePage(@PageableDefault(size = 12) Pageable pageable) {
        return ruleApplicationService.getRulePage(pageable);
    }

    @PostMapping
    public RulePresentation createRule(@RequestBody CreateRuleCommand command) {
        return ruleApplicationService.createRule(command);
    }

    @GetMapping("/{id}")
    public RulePresentation getRule(@PathVariable Long id) {
        return ruleApplicationService.getRule(id);
    }

    @PostMapping("/calculation")
    public CalculationPresentation calculate(@RequestBody CalculateOrderCommand command,
                                             @RequestParam String code) throws NotFoundException, NotApplicableRule, com.tw.rule.infrastructure.exception.NotFoundException {
        return ruleApplicationService.calculate(command, code);
    }
}
