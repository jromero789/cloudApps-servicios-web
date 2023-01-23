package com.codeurjc.arq1.dtos.request;

import java.util.List;

import com.codeurjc.arq1.dtos.response.ProductResponseDto;

public class ShoppingCartRequestDto {
    private List<ProductResponseDto> products;

    public List<ProductResponseDto> getProducts() {
        return products;
    }
    public void setProducts(List<ProductResponseDto> products) {
        this.products = products;
    }
}
