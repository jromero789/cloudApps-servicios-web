package com.codeurjc.arq1.services;

import com.codeurjc.arq1.dtos.request.ShoppingCartRequestDto;
import com.codeurjc.arq1.dtos.response.ShoppingCartResponseDto;

public interface ShoppingCartService {
    ShoppingCartResponseDto findById(Long id);
    ShoppingCartResponseDto create(ShoppingCartRequestDto shoppingCart);
    ShoppingCartResponseDto delete(Long id);
    ShoppingCartResponseDto finishShoppingCart(Long id);
    ShoppingCartResponseDto addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity);
    ShoppingCartResponseDto deleteProduct(Long cart_id, Long prod_id);
}
