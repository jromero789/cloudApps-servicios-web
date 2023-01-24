package com.codeurjc.arq1.domain.port;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto save(ProductDto product);
    Optional<ProductDto> delete(Long id);
}
