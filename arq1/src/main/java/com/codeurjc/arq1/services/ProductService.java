package com.codeurjc.arq1.services;

import java.util.Collection;

import com.codeurjc.arq1.dtos.response.ProductResponseDto;

public interface ProductService {
    
    Collection<ProductResponseDto> findAll();
}