package com.tw.rule.domain.repository;

import com.tw.rule.application.service.representation.RuleRepresentation;
import com.tw.rule.domain.model.Rule;

import java.util.Optional;

public interface RuleRepository {
    Rule save(Rule rule);

    Optional<Rule> findById(Long id);
}
