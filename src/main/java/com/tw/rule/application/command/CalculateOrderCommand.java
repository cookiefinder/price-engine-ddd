package com.tw.rule.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CalculateOrderCommand {
    private String customerId;
    private List<SelectedProduct> products;
    private LocalDateTime createdAt;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectedProduct {
        private String sku;
        private Long count;
    }
}
