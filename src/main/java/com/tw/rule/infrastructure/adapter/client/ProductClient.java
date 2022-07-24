package com.tw.rule.infrastructure.adapter.client;

import com.tw.rule.infrastructure.adapter.response.ProductResponse;

import java.util.Set;

public interface ProductClient {
    Set<ProductResponse> findBySkus(Set<String> skus);
}
