package com.dev.product_service.service;

import com.dev.product_service.dto.ProductDTO;
import com.dev.product_service.entity.Product;
import com.dev.product_service.repository.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
public class ProductService {
    private String product;
    private Float price;
    private Float cost;


    private final ProductRepository repository;
    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(repository.findAll());
    }

    public Product saveProducts(ProductDTO dto){
        return repository.save(new Product(dto));
    }


}
