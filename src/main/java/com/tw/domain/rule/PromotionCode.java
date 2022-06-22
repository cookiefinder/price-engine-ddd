package com.tw.domain.rule;

import java.util.UUID;

public class PromotionCode {
    private String code;

    public PromotionCode() {
        this.code = UUID.randomUUID().toString().replaceAll("-", "");
    }
}
