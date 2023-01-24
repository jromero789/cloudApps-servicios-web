package com.codeurjc.arq1.domain.port;

import java.util.Collection;

public interface ProductUseCase {
    public Collection<ProductDto> findAll();
    public ProductDto findById(Long id);
    public ProductDto create(ProductDto product);
    public ProductDto updateStock(Long id, int stock);
    public ProductDto delete(Long id); 
}
