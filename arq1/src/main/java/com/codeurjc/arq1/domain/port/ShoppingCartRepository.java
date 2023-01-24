package com.codeurjc.arq1.domain.port;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository {
        List<ShoppingCartDto> findAll();
        ShoppingCartDto findById(Long id);
        ShoppingCartDto save(ShoppingCartDto shoppingCart);
        Optional<ShoppingCartDto> delete(Long id);
}
