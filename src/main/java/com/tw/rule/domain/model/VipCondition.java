package com.tw.rule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VipCondition extends Condition {
    private Boolean justForVip;

    @Override
    public boolean applicable(Order order) {
        if (justForVip) {
            return order.getCustomer().isVip();
        }
        return true;
    }
}
