package com.codeurjc.arq1.domain.port;

import java.util.List;

public class ShoppingCartDto {
    
    private Long id;
    private List<ProductDto> products;

    public ShoppingCartDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
