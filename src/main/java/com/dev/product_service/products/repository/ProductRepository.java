package com.dev.product_service.products.repository;

import com.dev.product_service.products.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product,UUID> {

    Optional<Product> findByProductId(UUID productId);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.isDeleted = :isDeleted WHERE p.productId = :productId")
    void softDeleteByProductId(UUID productId, Boolean isDeleted);
}
