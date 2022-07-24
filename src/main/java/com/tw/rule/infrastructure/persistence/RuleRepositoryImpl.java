package com.tw.rule.infrastructure.persistence;

import com.tw.rule.domain.model.PromotionCode;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.model.RuleType;
import com.tw.rule.domain.repository.RuleRepository;
import com.tw.rule.infrastructure.persistence.mapper.RuleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RuleRepositoryImpl implements RuleRepository {
    private final JpaRuleRepository jpaRuleRepository;
    private final RuleMapper ruleMapper;

    @Override
    public Rule save(Rule rule) {
        return ruleMapper.toModel(jpaRuleRepository.save(ruleMapper.toPo(rule)));
    }

    @Override
    public Optional<Rule> findById(Long id) {
        return Optional.ofNullable(ruleMapper.toModel(jpaRuleRepository.findById(id).orElse(null)));
    }

    @Override
    public Page<Rule> findAll(Pageable pageable) {
        return jpaRuleRepository.findAll(pageable).map(ruleMapper::toModel);
    }

    @Override
    public Optional<Rule> findByPromotionCode(PromotionCode code) {
        return Optional.empty();
    }

    @Override
    public List<Rule> findAllByType(RuleType ruleType) {
        return null;
    }
}
