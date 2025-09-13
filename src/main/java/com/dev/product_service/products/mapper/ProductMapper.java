package com.dev.product_service.products.mapper;

import com.dev.product_service.products.dto.ProductListDTO;
import com.dev.product_service.products.dto.ProductRequestDTO;
import com.dev.product_service.products.dto.ProductResponseDTO;
import com.dev.product_service.products.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDTO toDTO(Product product);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "isDeleted", constant = "false")
    Product toEntity(ProductRequestDTO dto);
}
