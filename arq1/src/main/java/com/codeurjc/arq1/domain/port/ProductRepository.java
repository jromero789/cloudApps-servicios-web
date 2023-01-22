package com.codeurjc.arq1.domain.port;

import java.util.List;

public interface ProductRepository {
    
    List<ProductDto> findAllProducts();
    ProductDto createProduct(ProductDto product);
    
}
