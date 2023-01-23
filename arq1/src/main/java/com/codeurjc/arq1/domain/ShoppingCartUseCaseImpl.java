package com.codeurjc.arq1.domain;

import com.codeurjc.arq1.domain.port.ShoppingCartDto;
import com.codeurjc.arq1.domain.port.ShoppingCartRepository;
import com.codeurjc.arq1.domain.port.ShoppingCartUseCase;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

    ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCartDto findById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCartDto create(ShoppingCartDto shoppingCart) {
        return shoppingCartRepository.create(shoppingCart);
    }

    @Override
    public ShoppingCartDto delete(Long id) {
        ShoppingCartDto shoppingCart = shoppingCartRepository.findById(id);
        shoppingCartRepository.delete(id);
        return shoppingCart;
    }
    
    
}
