package com.codeurjc.arq1.domain;

import java.util.Collection;

import org.apache.catalina.mapper.Mapper;

import com.codeurjc.arq1.domain.port.ProductDto;
import com.codeurjc.arq1.domain.port.ProductRepository;
import com.codeurjc.arq1.domain.port.ProductUseCase;

public class ProductUseCaseImpl implements ProductUseCase {

    ProductRepository productRepository;

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<ProductDto> findAllProducts() {
        return productRepository.findAllProducts();
    }
    
    public ProductDto createProduct(ProductDto product) {
        return productRepository.createProduct(product);
    }

    // public ProductDto findProductById(long id){
    //     Product product = this.productRepository.findById(id);

    // }
}
