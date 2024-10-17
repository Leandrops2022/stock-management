package com.example.stock_management.infrastructure.security;

import jakarta.validation.constraints.NotBlank;

public record LoginCredentialsDTO(
        @NotBlank
        String username,
        @NotBlank
        String password) {
}
