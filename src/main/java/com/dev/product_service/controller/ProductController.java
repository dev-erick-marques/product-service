package com.dev.product_service.controller;

import com.dev.product_service.dto.ProductDTO;
import com.dev.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<?> setProducts(@RequestBody ProductDTO dto){
        service.saveProducts(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto cadastrado com sucesso");
    }
}
