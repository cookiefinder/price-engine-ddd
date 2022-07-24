package com.tw.rule.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PromotionCode {
    private String code;

    private PromotionCode(String code) {
        this.code = code;
    }

    public static PromotionCode init() {
        String code = UUID.randomUUID().toString().replaceAll("-", "");
        return new PromotionCode(code);
    }

    public static PromotionCode of(String promotionCode) {
        return new PromotionCode(promotionCode);
    }
}
