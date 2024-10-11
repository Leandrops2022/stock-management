package com.example.stock_management.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record UserCreationDTO(
        @Email(message = "Must be a valid email address")
        String username,
        @Size(min = 6, max = 12)
        String password) {
}
