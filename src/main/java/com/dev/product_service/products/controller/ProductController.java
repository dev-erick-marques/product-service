package com.dev.product_service.products.controller;

import com.dev.product_service.products.dto.ProductListDTO;
import com.dev.product_service.products.dto.ProductRequestDTO;
import com.dev.product_service.products.dto.ProductResponseDTO;
import com.dev.product_service.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<ProductListDTO> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    @PostMapping
    public ResponseEntity<Void> registerProduct(@RequestBody ProductRequestDTO dto){
        service.saveProducts(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id){
        return ResponseEntity.ok()
                .body(service.getProductById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        service.softDeleteProductById(id, true);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/restore")
    public ResponseEntity<Void> restoreProduct(@PathVariable UUID id){
        service.softDeleteProductById(id, false);
        return ResponseEntity.noContent().build();
    }

}
