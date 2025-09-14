package com.dev.product_service.categories.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequestDTO(
        @NotNull(message = "The field categoryName can't be null")
        String categoryName) {
}
