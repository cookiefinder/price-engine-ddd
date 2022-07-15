package com.tw.rule.domain.repository;

import com.tw.rule.domain.model.Rule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RuleRepository {
    Rule save(Rule rule);

    Optional<Rule> findById(Long id);

    Page<Rule> findAll(Pageable pageable);
}
