package com.codeurjc.arq1.services;

import java.util.Collection;

import com.codeurjc.arq1.dtos.request.ProductRequestDto;
import com.codeurjc.arq1.dtos.response.ProductResponseDto;

public interface ProductService {
    
    Collection<ProductResponseDto> findAll();
    ProductResponseDto findById(Long id);
    ProductResponseDto create(ProductRequestDto product);
    ProductResponseDto updateStock(int stock);
    ProductResponseDto delete(Long id);
}
