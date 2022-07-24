package com.tw.rule.infrastructure.adapter.client;

import com.tw.rule.infrastructure.adapter.response.CustomerResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface CustomerClient {
    @GetMapping
    CustomerResponse findById(String id);
}
