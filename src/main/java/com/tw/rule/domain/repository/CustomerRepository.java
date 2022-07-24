package com.tw.rule.domain.repository;

import com.tw.rule.domain.model.Customer;
import com.tw.rule.domain.model.CustomerId;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(CustomerId customerId);
}
