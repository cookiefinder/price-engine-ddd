package com.tw.rule.infrastructure.persistence;

import com.tw.rule.infrastructure.persistence.po.RulePo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRuleRepository extends JpaRepository<RulePo, Long> {
}
