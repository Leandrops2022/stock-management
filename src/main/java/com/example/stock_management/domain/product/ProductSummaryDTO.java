package com.example.stock_management.domain.product;

import java.math.BigDecimal;

public record ProductSummaryDTO(Long id, String name, BigDecimal price) {
    public ProductSummaryDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}
