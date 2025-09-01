package com.dev.product_service.service;

import com.dev.product_service.dto.ProductDTO;
import com.dev.product_service.entity.Product;
import com.dev.product_service.exceptions.ResourceNotFoundException;
import com.dev.product_service.repository.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Product> getAllProducts(){
        List<Product> products = repository.findAll();
        if(products.isEmpty())
            throw new ResourceNotFoundException("Não há produtos cadastrados");
        return products;

    }
    public Optional<Product> getProductById(Long id){
        Optional<Product> product = repository.findById(id);
        product.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: "+id));
        return  product;
    }
    public void deleteProductById(Long id){
        Optional<Product> product = repository.findById(id);
        product.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: "+id) );
        repository.deleteById(id);
    }

    public void saveProducts(ProductDTO dto){
        repository.save(new Product(dto));
    }


}
