package com.tw.domain.rule;

public interface Condition {
    boolean applicable(Order order);
}