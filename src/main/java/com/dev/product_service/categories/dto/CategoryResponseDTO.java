package com.dev.product_service.categories.dto;

import java.util.UUID;

public record CategoryResponseDTO(UUID categoryId,
                                  String categoryName) {
}
