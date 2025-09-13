package com.dev.product_service.products.dto;

import java.util.UUID;

public record ProductRequestDTO(
        UUID categoryId,
        String productName,
        String description) {
}
