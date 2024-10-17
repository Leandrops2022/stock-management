package com.example.stock_management.application.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record RegisterProductDTO(
        @NotBlank
        String name,
        @NotNull
        BigDecimal price,
        @Size(min = 6, max = 8)
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "SKU must contain only letters and numbers.")
        String sku) {
}
