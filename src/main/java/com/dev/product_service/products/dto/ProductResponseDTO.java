package com.dev.product_service.products.dto;

import java.util.UUID;

public record ProductResponseDTO(
        UUID productId,
        UUID categoryId,
        String productName,
        String description){}
