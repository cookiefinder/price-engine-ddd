package com.tw.rule.domain.repository;

import com.tw.rule.domain.model.Product;
import com.tw.rule.domain.model.ProductSku;

import java.util.List;
import java.util.Set;

public interface ProductRepository {
    List<Product> findBySkus(Set<ProductSku> productSkus);
}
