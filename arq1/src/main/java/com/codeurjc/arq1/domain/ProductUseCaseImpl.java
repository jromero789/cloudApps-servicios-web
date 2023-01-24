package com.codeurjc.arq1.domain;

import java.util.Collection;

import org.dozer.Mapper;

import com.codeurjc.arq1.domain.port.ProductDto;
import com.codeurjc.arq1.domain.port.ProductRepository;
import com.codeurjc.arq1.domain.port.ProductUseCase;

public class ProductUseCaseImpl implements ProductUseCase {

    ProductRepository productRepository;
    private Mapper mapper;

    public ProductUseCaseImpl(ProductRepository productRepository, Mapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
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
        return productRepository.save(product);
    }

    @Override
    public ProductDto updateStock(Long id, int stock) {

        ProductDto product = productRepository.findById(id);
        
        Product domainProduct = mapper.map(product, Product.class);
        domainProduct.updateStock(stock);

        ProductDto modifiedProductDto = mapper.map(domainProduct, ProductDto.class);
        return productRepository.save(modifiedProductDto);
    }

    @Override
    public ProductDto delete(Long id) {
        ProductDto product = productRepository.findById(id);
        productRepository.delete(id);
        return product;
    }
    
}
