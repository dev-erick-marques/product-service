package com.dev.product_service.categories.controller;

import com.dev.product_service.categories.dto.CategoryListResponse;
import com.dev.product_service.categories.dto.CategoryRequestDTO;
import com.dev.product_service.categories.dto.CategoryResponseDTO;
import com.dev.product_service.categories.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable UUID id){
        return  ResponseEntity.ok(
                service.getCategoryById(id)
        );
    }
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> registerCategory(@RequestBody CategoryRequestDTO dto){
        System.out.println(dto.categoryName() + "controller");
        return ResponseEntity.ok(service.registerCategory(dto));
    }
    @GetMapping
    public ResponseEntity<CategoryListResponse> getAllCategories(){
        return ResponseEntity.ok().body(
                service.getAllCategories()
        );
    }
}
