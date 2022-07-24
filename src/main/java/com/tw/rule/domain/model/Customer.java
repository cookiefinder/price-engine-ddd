package com.tw.rule.domain.model;

public class Customer {
    private CustomerId id;
    private String name;
    private boolean vip;

    private Customer(CustomerId id, String name, boolean vip) {
        this.id = id;
        this.name = name;
        this.vip = vip;
    }

    public static Customer from(CustomerId customerId, String name, Boolean vip) {
        return new Customer(customerId, name, vip);
    }

    public boolean isVip() {
        return this.vip;
    }
}
