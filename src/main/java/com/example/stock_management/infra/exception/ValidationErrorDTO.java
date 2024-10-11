package com.example.stock_management.infra.exception;

import java.util.LinkedHashMap;

public record ValidationErrorDTO(LinkedHashMap errors) {
}
