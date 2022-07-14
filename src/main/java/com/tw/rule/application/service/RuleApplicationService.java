package com.tw.rule.application.service;

import com.tw.rule.application.service.command.CreateRuleCommand;
import com.tw.rule.application.service.representation.RuleRepresentation;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RuleApplicationService {
    private final RuleRepository ruleRepository;

    @Transactional
    public RuleRepresentation createRule(CreateRuleCommand command) {
        Rule savedRule = ruleRepository.save(command.toRule());
        return RuleRepresentation.from(savedRule);
    }

    @Transactional(readOnly = true)
    public RuleRepresentation getRuleDetail(Long id) {
        return ruleRepository.findById(id)
                .map(RuleRepresentation::from)
                .orElse(null);
    }
}
