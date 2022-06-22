package com.tw.domain.rule;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Order {
    private Customer customer;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;
    private BigDecimal totalAmount;

    public Order(Customer customer, List<OrderItem> orderItems, LocalDateTime createdAt) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
        this.totalAmount = getOrderAmount();
    }

    public BigDecimal getOrderAmount() {
        return orderItems.stream().map(OrderItem::getAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public void discount(BigDecimal discountedPrice) {
        totalAmount = discountedPrice;
    }
}
