package com.tw.rule.domain.service;

import com.tw.rule.domain.exception.NotApplicableRule;
import com.tw.rule.domain.exception.NotFoundException;
import com.tw.rule.domain.model.CalculatedResult;
import com.tw.rule.domain.model.Order;
import com.tw.rule.domain.model.PromotionCode;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.model.RuleType;
import com.tw.rule.domain.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RuleService {
    private final RuleRepository ruleRepository;

    public List<Rule> applicableRules(Order order, String promotionCode) throws NotFoundException, NotApplicableRule {
        if (Objects.nonNull(promotionCode)) {
            Rule foundRule = ruleRepository.findByPromotionCode(PromotionCode.of(promotionCode))
                    .orElseThrow(() -> new NotFoundException("Not found rule when promotion code=" + promotionCode));
            if (!foundRule.applicable(order)) {
                throw new NotApplicableRule("The order can't apply the rule, code=" + promotionCode);
            }
            return List.of(foundRule);
        }
        List<Rule> foundRules = ruleRepository.findAllByType(RuleType.GENERAL);
        List<Rule> applicableRules = foundRules.stream().filter(rule -> rule.applicable(order)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(applicableRules)) {
            throw new NotApplicableRule("The order not found any applicable rule");
        }
        return applicableRules;
    }

    public CalculatedResult calculateOrder(Order order, List<Rule> rules) {
        return rules.stream().map(rule -> rule.calculate(order)).min(CalculatedResult::compareTo)
                .orElse(CalculatedResult.of(order.getOriginalAmount()));
    }
}
