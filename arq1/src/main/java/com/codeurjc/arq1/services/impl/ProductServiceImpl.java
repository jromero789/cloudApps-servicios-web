package com.codeurjc.arq1.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.codeurjc.arq1.domain.port.ProductUseCase;
import com.codeurjc.arq1.dtos.request.ProductRequestDto;
import com.codeurjc.arq1.dtos.response.ProductResponseDto;
import com.codeurjc.arq1.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private Mapper mapper;
    private ProductUseCase productUseCase;

    public ProductServiceImpl(Mapper mapper, ProductUseCase productUseCase) {
        this.mapper = mapper;
        this.productUseCase = productUseCase;
    }

    @Override
    public Collection<ProductResponseDto> findAll() {
        return this.productUseCase.findAll().stream()
                .map(product -> this.mapper.map(product, ProductResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductResponseDto create(ProductRequestDto product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductResponseDto updateStock(int stock) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductResponseDto delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
