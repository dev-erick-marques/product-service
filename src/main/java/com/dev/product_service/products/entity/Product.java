package com.dev.product_service.products.entity;

import com.dev.product_service.products.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;
    private UUID categoryId;
    private String productName;
    private String description;
    private Boolean isDeleted;

    public Product(ProductRequestDTO dto){
        this.productName = dto.productName();
        this.categoryId = dto.categoryId();
        this.description = dto.description();
    }
    public Product(){}

}
