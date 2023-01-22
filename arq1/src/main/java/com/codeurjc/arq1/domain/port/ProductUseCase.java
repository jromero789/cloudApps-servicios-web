package com.codeurjc.arq1.domain.port;

import java.util.Collection;

public interface ProductUseCase {

    public Collection<ProductDto> findAllProducts();
    
}
