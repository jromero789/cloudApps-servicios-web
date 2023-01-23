package com.codeurjc.arq1.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeurjc.arq1.infrastructure.models.ShoppingCartEntity;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Long> {
}
