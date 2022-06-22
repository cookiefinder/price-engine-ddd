package com.tw.infrastructure.persistence;

import com.tw.domain.rule.Rule;
import com.tw.domain.rule.repository.RuleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RuleRepositoryImpl implements RuleRepository {

    @Override
    public Rule save(Rule rule) {
        return null;
    }
}
