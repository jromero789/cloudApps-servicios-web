package com.codeurjc.arq1.domain.port;

public interface ShoppingCartRepository {
        ShoppingCartDto findById(Long id);
        ShoppingCartDto create(ShoppingCartDto shoppingCart);
        void delete(Long id);
        ShoppingCartDto finishShoppingCart(Long id);
        ShoppingCartDto addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity );
}
