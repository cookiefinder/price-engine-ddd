package com.tw.rule.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {
    private Customer customer;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;

    private Order(Customer customer, List<OrderItem> orderItems, LocalDateTime createdAt) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
    }

    public static Order init(Customer customer, List<OrderItem> orderItems, LocalDateTime createdAt) {
        return new Order(customer, orderItems, createdAt);
    }

    public BigDecimal getOriginalAmount() {
        return orderItems.stream().map(OrderItem::getAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
