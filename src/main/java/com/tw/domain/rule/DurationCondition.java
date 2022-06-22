package com.tw.domain.rule;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class DurationCondition implements Condition {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public boolean applicable(Order order) {
        LocalDateTime createdAt = order.getCreatedAt();
        return createdAt.isAfter(startTime) && createdAt.isBefore(endTime);
    }
}
