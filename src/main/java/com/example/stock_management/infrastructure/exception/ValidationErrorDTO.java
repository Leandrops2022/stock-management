package com.example.stock_management.infrastructure.exception;

import java.util.LinkedHashMap;

public record ValidationErrorDTO(LinkedHashMap errors) {
}
