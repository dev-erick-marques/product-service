package com.dev.product_service.products.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductRequestDTO(
        UUID categoryId,
        @NotNull(message = "The field productName can´t be null")
        String productName,
        String description) {
}
