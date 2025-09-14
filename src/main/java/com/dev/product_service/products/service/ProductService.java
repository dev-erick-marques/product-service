package com.dev.product_service.products.service;

import com.dev.product_service.products.dto.ProductListDTO;
import com.dev.product_service.products.dto.ProductResponseDTO;
import com.dev.product_service.products.entity.Product;
import com.dev.product_service.common.exception.ResourceNotFoundException;
import com.dev.product_service.products.mapper.ProductMapper;
import com.dev.product_service.products.repository.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Getter @Setter
@Service
public class ProductService {
    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
    private final ProductRepository repository;
    
    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public ProductListDTO getAllProducts(){
        var products = repository.findAll();
        if(products.isEmpty())
            throw new ResourceNotFoundException("No products were found");
        return new ProductListDTO(products
                .stream()
                .map(mapper::toDTO)
                .toList()
        );
    }
    public ProductResponseDTO getProductById(UUID id){
        Optional<Product> product = repository.findByProductId(id);
        product.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return mapper.toDTO(product.get());
    }
    public void softDeleteProductById(UUID id, Boolean isDeleted){
        Optional<Product> product = repository.findByProductId(id);
        product.orElseThrow(() -> new ResourceNotFoundException("Product not found") );
        repository.softDeleteByProductId(id, isDeleted);
    }

    public void saveProducts(ProductResponseDTO dto){
        repository.save(new Product(dto));
    }


}
