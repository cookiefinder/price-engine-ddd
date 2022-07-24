package com.tw.rule.infrastructure.adapter.impl;

import com.tw.rule.domain.model.Product;
import com.tw.rule.domain.model.ProductSku;
import com.tw.rule.domain.repository.ProductRepository;
import com.tw.rule.infrastructure.adapter.client.ProductClient;
import com.tw.rule.infrastructure.adapter.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductClient productClient;

    @Override
    public List<Product> findBySkus(Set<ProductSku> productSkus) {
        Set<ProductResponse> response = productClient.findBySkus(productSkus.stream().map(ProductSku::getSku).collect(Collectors.toSet()));
        return response.stream().map(ProductResponse::toProduct).collect(Collectors.toList());
    }
}
