package com.tw.rule.infrastructure.adapter.impl;

import com.tw.rule.domain.model.Customer;
import com.tw.rule.domain.model.CustomerId;
import com.tw.rule.domain.repository.CustomerRepository;
import com.tw.rule.infrastructure.adapter.client.CustomerClient;
import com.tw.rule.infrastructure.adapter.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerClient customerClient;

    @Override
    public Optional<Customer> findById(CustomerId customerId) {
        CustomerResponse response = customerClient.findById(customerId.getId());
        if (Objects.nonNull(response)) {
            return Optional.of(response.toCustomer());
        }
        return Optional.empty();
    }
}
