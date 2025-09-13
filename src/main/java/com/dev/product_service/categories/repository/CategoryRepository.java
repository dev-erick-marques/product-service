package com.dev.product_service.categories.repository;

import com.dev.product_service.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
