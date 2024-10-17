package com.example.stock_management.application.dto.product;

import com.example.stock_management.domain.product.Product;

import java.math.BigDecimal;

public record ProductPresentationDTO(String name, BigDecimal price) {
    public ProductPresentationDTO(Product product){
        this(product.getName(), product.getPrice());
    }
}
