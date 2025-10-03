package com.dev.product_service.products.service;

import com.dev.product_service.products.dto.ProductResponseDTO;
import com.dev.product_service.products.entity.Product;
import com.dev.product_service.products.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @DisplayName("Get product by id when product exists return productDTO")
    @Test
    void getProductById_whenProductExists() {
        UUID categoryId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        Product product = new Product(categoryId, "Samsung Galaxy S23 FE", "test");
        ReflectionTestUtils.setField(product, "productId", productId);

        Mockito.when(productRepository.findByProductId(Mockito.any())).thenReturn(Optional.of(product));
        ProductResponseDTO testResult = productService.getProductById(product.getProductId());

        Assertions.assertEquals(categoryId, testResult.categoryId());
        Assertions.assertEquals(productId, testResult.productId());
    }


}