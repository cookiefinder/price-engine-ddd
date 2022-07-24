package com.tw.rule.infrastructure.adapter.response;

import com.tw.rule.domain.model.Customer;
import com.tw.rule.domain.model.CustomerId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private String id;
    private String name;
    private Boolean vip;

    public Customer toCustomer() {
        return Customer.from(CustomerId.of(id), name, vip);
    }
}
