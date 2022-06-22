package com.tw.domain.rule;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VipCondition implements Condition {
    private boolean isVip;

    @Override
    public boolean applicable(Order order) {
        if (isVip) {
            return order.getCustomer().isVip();
        }
        return true;
    }
}
