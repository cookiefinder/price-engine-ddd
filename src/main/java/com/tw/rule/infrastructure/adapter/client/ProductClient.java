package com.tw.rule.infrastructure.adapter.client;

import com.tw.rule.infrastructure.adapter.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(value = "product", url = "http://localhost:8090/api/products")
public interface ProductClient {
    @GetMapping
    Set<ProductResponse> findBySkus(Set<String> skus);
}
