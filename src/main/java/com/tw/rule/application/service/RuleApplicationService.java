package com.tw.rule.application.service;

import com.tw.rule.application.command.CreateRuleCommand;
import com.tw.rule.application.presentation.RulePagePresentation;
import com.tw.rule.application.presentation.RulePresentation;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RuleApplicationService {
    private final RuleRepository ruleRepository;

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
}
