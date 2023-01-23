package com.codeurjc.arq1.domain;

import java.util.Collection;

import com.codeurjc.arq1.domain.port.ProductDto;
import com.codeurjc.arq1.domain.port.ProductRepository;
import com.codeurjc.arq1.domain.port.ProductUseCase;

public class ProductUseCaseImpl implements ProductUseCase {

    ProductRepository productRepository;

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<ProductDto> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductDto create(ProductDto product) {
        return productRepository.create(product);
    }

    @Override
    public ProductDto updateStock(int stock) {
        return productRepository.updateStock(stock);
    }

    @Override
    public ProductDto delete(Long id) {
        ProductDto product = productRepository.findById(id);
        productRepository.delete(id);
        return product;
    }
    
}
