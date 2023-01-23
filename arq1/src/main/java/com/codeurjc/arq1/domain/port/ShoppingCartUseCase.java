package com.codeurjc.arq1.domain.port;

public interface ShoppingCartUseCase {
    public ShoppingCartDto findById(Long id);
    public ShoppingCartDto create(ShoppingCartDto shoppingCart);
    public ShoppingCartDto delete(Long id); 
}
