package com.dev.product_service.categories.service;

import com.dev.product_service.categories.dto.CategoryListResponse;
import com.dev.product_service.categories.dto.CategoryRequestDTO;
import com.dev.product_service.categories.dto.CategoryResponseDTO;
import com.dev.product_service.categories.entity.Category;
import com.dev.product_service.categories.mapper.CategoryMapper;
import com.dev.product_service.categories.repository.CategoryRepository;
import com.dev.product_service.exceptions.ResourceNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository repository;


    private final CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    public CategoryResponseDTO registerCategory(CategoryRequestDTO dto){
        Category category = mapper.toEntity(dto);
        System.out.println(category.getCategoryName()  + " service, id: "+ category.getCategoryId());
        Category saved = repository.save(category);
        return mapper.toDTO(saved);
    }
    public CategoryResponseDTO getCategoryById(UUID id){
         Optional<Category> category = repository.findById(id);
         if(category.isEmpty()){
             throw new ResourceNotFoundException("Category not found");
         }
         return mapper.toDTO(category.get());
    }
    public CategoryListResponse getAllCategories(){
        return new CategoryListResponse(
                repository.findAll()
                        .stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }
}
