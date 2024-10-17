package com.example.stock_management.application.dto.user;

import com.example.stock_management.domain.user.User;

public record NewUserDTO(Long id, String name) {
    public NewUserDTO(User user) {
        this(user.getId(), user.getUsername());
    }
}
