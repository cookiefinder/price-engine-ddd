package com.tw.application.service;

import com.tw.application.service.command.CreateRuleCommand;
import com.tw.application.service.representation.RuleRepresentation;
import com.tw.domain.rule.Rule;
import com.tw.domain.rule.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PriceEngineApplicationService {
    private final RuleRepository ruleRepository;

    @Transactional
    public RuleRepresentation createRule(CreateRuleCommand command) {
        Rule savedRule = ruleRepository.save(command.toRule());
        return RuleRepresentation.from(savedRule);
    }
}
