package com.example.stock_management.domain.user;

public record NewUserDTO(Long id, String name) {
    public NewUserDTO(User user) {
        this(user.getId(), user.getUsername());
    }
}
