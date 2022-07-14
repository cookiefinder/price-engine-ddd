package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VipCondition extends Condition {
    private Boolean isVip;

    @Override
    public boolean applicable(Order order) {
        if (isVip) {
            return order.getCustomer().isVip();
        }
        return true;
    }
}
