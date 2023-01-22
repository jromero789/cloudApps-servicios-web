package com.codeurjc.arq1.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.codeurjc.arq1.domain.port.ProductUseCase;
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
        return this.productUseCase.findAllProducts().stream()
                .map(product -> this.mapper.map(product, ProductResponseDto.class))
                .collect(Collectors.toList());
    }
    
}
