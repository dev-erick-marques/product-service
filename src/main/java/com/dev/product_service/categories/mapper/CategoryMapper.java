package com.dev.product_service.categories.mapper;

import com.dev.product_service.categories.dto.CategoryRequestDTO;
import com.dev.product_service.categories.dto.CategoryResponseDTO;
import com.dev.product_service.categories.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "isDeleted",constant = "false")
    Category toEntity(CategoryRequestDTO dto);


    CategoryResponseDTO toDTO(Category category);

}
