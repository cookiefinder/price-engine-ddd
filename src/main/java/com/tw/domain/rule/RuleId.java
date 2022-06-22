package com.tw.domain.rule;

import java.time.Instant;

public class RuleId {
    private Long id;

    public RuleId() {
        this.id = Instant.now().toEpochMilli();
    }
}
