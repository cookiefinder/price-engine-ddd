package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DurationCondition extends Condition {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public boolean applicable(Order order) {
        LocalDateTime createdAt = order.getCreatedAt();
        return createdAt.isAfter(startTime) && createdAt.isBefore(endTime);
    }
}
