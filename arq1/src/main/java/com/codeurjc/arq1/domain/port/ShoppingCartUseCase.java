package com.codeurjc.arq1.domain.port;

public interface ShoppingCartUseCase {
    public ShoppingCartDto findById(Long id);
    public ShoppingCartDto create(ShoppingCartDto shoppingCart);
    public ShoppingCartDto delete(Long id); 
    public ShoppingCartDto finishShoppingCart(Long id);
    public ShoppingCartDto addProductToShoppingCart(Long cartId, Long prodId, int prodQuantity);
    public ShoppingCartDto deleteProduct(Long cartId, Long prodId);
}
