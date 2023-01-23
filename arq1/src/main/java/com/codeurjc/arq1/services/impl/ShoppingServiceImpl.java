package com.codeurjc.arq1.services.impl;

import com.codeurjc.arq1.dtos.request.ShoppingCartRequestDto;
import com.codeurjc.arq1.dtos.response.ShoppingCartResponseDto;
import com.codeurjc.arq1.services.ShoppingCartService;

public class ShoppingServiceImpl implements ShoppingCartService {
    
    @Override
    public ShoppingCartResponseDto findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShoppingCartResponseDto create(ShoppingCartRequestDto shoppingCart) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShoppingCartResponseDto delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShoppingCartResponseDto finishShoppingCart(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShoppingCartResponseDto addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShoppingCartResponseDto deleteProduct(Long cart_id, Long prod_id) {
        // TODO Auto-generated method stub
        return null;
    }
}
