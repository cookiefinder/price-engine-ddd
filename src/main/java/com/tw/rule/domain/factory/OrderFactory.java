package com.tw.rule.domain.factory;

import com.tw.rule.application.command.CalculateOrderCommand;
import com.tw.rule.domain.model.Customer;
import com.tw.rule.domain.model.CustomerId;
import com.tw.rule.domain.model.Order;
import com.tw.rule.domain.model.OrderItem;
import com.tw.rule.domain.model.Product;
import com.tw.rule.domain.model.ProductSku;
import com.tw.rule.domain.repository.CustomerRepository;
import com.tw.rule.domain.repository.ProductRepository;
import com.tw.rule.infrastructure.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderFactory {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public Order buildOrder(CalculateOrderCommand command) throws NotFoundException {
        Customer customer = customerRepository.findById(CustomerId.of(command.getCustomerId()))
                .orElseThrow(() -> new NotFoundException("Not found customer by id=" + command.getCustomerId()));
        Map<ProductSku, Product> productSkuToProductMap = productRepository.findBySkus(command.getProducts().stream()
                        .map(CalculateOrderCommand.SelectedProduct::getSku)
                        .map(ProductSku::of)
                        .collect(Collectors.toSet()))
                .stream().collect(Collectors.toMap(Product::getProductSku, Function.identity()));
        Set<String> distinctSkus = command.getProducts().stream().map(CalculateOrderCommand.SelectedProduct::getSku).collect(Collectors.toSet());
        int expectSize = distinctSkus.size();
        int actualSize = productSkuToProductMap.size();
        if (!Objects.equals(expectSize, actualSize)) {
            throw new NotFoundException("Exist invalid sku, skus=" + distinctSkus);
        }
        List<OrderItem> orderItems = command.getProducts().stream().map(selectedProduct -> {
            ProductSku productSku = ProductSku.of(selectedProduct.getSku());
            Product product = productSkuToProductMap.get(productSku);
            return OrderItem.init(product.getProductSku(), product.getPrice(), selectedProduct.getCount());
        }).collect(Collectors.toList());
        return Order.init(customer, orderItems, command.getCreatedAt());
    }
}
