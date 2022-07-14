package com.tw.rule.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class PromotionCode {
    private String code;

    public PromotionCode() {
        this.code = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public PromotionCode(String code) {
        this.code = code;
    }
}
