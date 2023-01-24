package com.codeurjc.arq1.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.codeurjc.arq1.domain.port.ProductDto;
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
        ProductDto product = this.productUseCase.findById(id);
        return this.mapper.map(product, ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        ProductDto product = this.mapper.map(productRequestDto, ProductDto.class);
        return this.mapper.map(this.productUseCase.create(product), ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto updateStock(Long id, int stock) {
        return this.mapper.map(this.productUseCase.updateStock(id, stock), ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto delete(Long id) {
        ProductDto product = this.productUseCase.delete(id);
        return this.mapper.map(product, ProductResponseDto.class);
    }

    
}
