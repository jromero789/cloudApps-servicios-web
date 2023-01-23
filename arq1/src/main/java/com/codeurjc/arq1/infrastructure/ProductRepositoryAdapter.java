package com.codeurjc.arq1.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;

import com.codeurjc.arq1.domain.port.ProductDto;
import com.codeurjc.arq1.domain.port.ProductRepository;
import com.codeurjc.arq1.infrastructure.models.ProductEntity;
import com.codeurjc.arq1.infrastructure.repositories.ProductJpaRepository;

public class ProductRepositoryAdapter implements ProductRepository {
    
    private ProductJpaRepository productJpaRepository;
	private Mapper mapper;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository, Mapper mapper) {
        this.productJpaRepository = productJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> products = productJpaRepository.findAll();
		
		return products
				.stream()
				.map(p -> mapper.map(p, ProductDto.class))
				.collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        ProductEntity productEntity = productJpaRepository.findById(id).orElseThrow();
		return mapper.map(productEntity, ProductDto.class);
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        ProductEntity product = this.mapper.map(productDto, ProductEntity.class);
        product = this.productJpaRepository.save(product);
        return this.mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateStock(int stock) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        this.productJpaRepository.deleteById(id);
    }
}
