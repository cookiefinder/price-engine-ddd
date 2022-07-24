package com.tw.rule.application.service;

import com.tw.rule.application.command.CalculateOrderCommand;
import com.tw.rule.application.command.CreateRuleCommand;
import com.tw.rule.application.presentation.CalculationPresentation;
import com.tw.rule.application.presentation.RulePagePresentation;
import com.tw.rule.application.presentation.RulePresentation;
import com.tw.rule.domain.exception.NotApplicableRule;
import com.tw.rule.domain.exception.NotFoundException;
import com.tw.rule.domain.factory.OrderFactory;
import com.tw.rule.domain.model.CalculatedResult;
import com.tw.rule.domain.model.Order;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.repository.RuleRepository;
import com.tw.rule.domain.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RuleApplicationService {
    private final RuleRepository ruleRepository;
    private final RuleService ruleService;
    private final OrderFactory orderFactory;

    @Transactional
    public RulePresentation createRule(CreateRuleCommand command) {
        Rule savedRule = ruleRepository.save(command.toRule());
        return RulePresentation.from(savedRule);
    }

    @Transactional(readOnly = true)
    public RulePresentation getRule(Long id) {
        return ruleRepository.findById(id)
                .map(RulePresentation::from)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public RulePagePresentation getRulePage(Pageable pageable) {
        return RulePagePresentation.from(ruleRepository.findAll(pageable));
    }

    @Transactional
    public CalculationPresentation calculate(CalculateOrderCommand command, String promotionCode) throws NotFoundException, NotApplicableRule, com.tw.rule.infrastructure.exception.NotFoundException {
        Order order = orderFactory.buildOrder(command);
        List<Rule> applicableRules = ruleService.applicableRules(order, promotionCode);
        CalculatedResult result = ruleService.calculateOrder(order, applicableRules);
        return CalculationPresentation.from(result);
    }
}
