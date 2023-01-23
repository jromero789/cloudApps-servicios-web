package com.codeurjc.arq1.domain.port;

import java.util.List;

public interface ProductRepository {
    
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto create(ProductDto product);
    ProductDto updateStock(int stock);
    void delete(Long id);
}
