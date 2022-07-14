package com.tw.rule.domain.model;

import lombok.Getter;

import java.time.Instant;

@Getter
public class RuleId {
    private Long id;

    public RuleId() {
        this.id = Instant.now().toEpochMilli();
    }

    public RuleId(Long id) {
        this.id = id;
    }
}
