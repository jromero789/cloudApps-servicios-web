package com.codeurjc.arq1.dtos.response;

import java.util.List;

public class ShoppingCartResponseDto {

    private List<ProductResponseDto> products;

    public List<ProductResponseDto> getProducts() {
        return products;
    }
    public void setProducts(List<ProductResponseDto> products) {
        this.products = products;
    }
}
