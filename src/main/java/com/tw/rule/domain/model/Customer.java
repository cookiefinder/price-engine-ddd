package com.tw.rule.domain.model;

public class Customer {
    private CustomerId id;
    private String name;
    private boolean vip;

    public boolean isVip() {
        return this.vip;
    }
}
