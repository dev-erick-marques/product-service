package com.dev.product_service.controller;

import com.dev.product_service.dto.ProductDTO;
import com.dev.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<?> setProducts(@RequestBody ProductDTO dto){
        service.saveProducts(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto cadastrado com sucesso");
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Produto deletado com sucesso");
    }

}
