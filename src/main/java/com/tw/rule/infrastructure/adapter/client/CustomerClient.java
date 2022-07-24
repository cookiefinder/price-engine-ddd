package com.tw.rule.infrastructure.adapter.client;

import com.tw.rule.infrastructure.adapter.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customer", url = "http://localhost:8091/api/customers")
public interface CustomerClient {
    @GetMapping("/{id}")
    CustomerResponse findById(@PathVariable String id);
}
