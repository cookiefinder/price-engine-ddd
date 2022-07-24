package com.tw.rule.domain.model;

import lombok.Getter;

@Getter
public class CustomerId {
    private String id;

    private CustomerId(String id) {
        this.id = id;
    }

    public static CustomerId of(String id) {
        return new CustomerId(id);
    }
}
