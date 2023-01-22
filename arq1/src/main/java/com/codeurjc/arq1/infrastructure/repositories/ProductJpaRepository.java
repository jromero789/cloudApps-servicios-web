package com.codeurjc.arq1.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeurjc.arq1.infrastructure.models.ProductEntity;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    
}
