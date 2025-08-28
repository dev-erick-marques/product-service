package com.dev.product_service.entity;

import com.dev.product_service.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String product;
    private Float price;
    private Float cost;

    public Product(ProductDTO dto){
        this.product = dto.product();
        this.price = dto.price();
        this.cost = dto.cost();
    }
    public Product(){}
}
