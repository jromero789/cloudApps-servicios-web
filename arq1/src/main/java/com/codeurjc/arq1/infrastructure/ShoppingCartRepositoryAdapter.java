package com.codeurjc.arq1.infrastructure;

import org.apache.catalina.mapper.Mapper;

import com.codeurjc.arq1.domain.port.ShoppingCartDto;
import com.codeurjc.arq1.domain.port.ShoppingCartRepository;
import com.codeurjc.arq1.infrastructure.models.ShoppingCartEntity;
import com.codeurjc.arq1.infrastructure.repositories.ShoppingCartJpaRepository;

public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

    private ShoppingCartJpaRepository shoppingCartJpaRepository;
    private Mapper mapper;

    public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository, Mapper mapper) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ShoppingCartDto findById(Long id) {
        ShoppingCartEntity shoppingCartEntity = shoppingCartJpaRepository.findById(id).orElseThrow();
        return null; // mapper.map(shoppingCartEntity, ShoppingCartDto.class);
    }

    @Override
    public ShoppingCartDto create(ShoppingCartDto shoppingCartDto) {
        // ShoppingCartEntity shoppingCart = this.mapper.map(shoppingCartDto, ShoppingCartEntity.class);
        // shoppingCart = this.shoppingCartJpaRepository.save(shoppingCart);
        // return this.mapper.map(shoppingCart, ShoppingCartDto.class);
        return null;
    }

    @Override
    public void delete(Long id) {
        this.shoppingCartJpaRepository.deleteById(id);
    }

    @Override
    public ShoppingCartDto finishShoppingCart(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ShoppingCartDto addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity) {
        ShoppingCartEntity shoppingCartEntity = shoppingCartJpaRepository.findById(cart_id).orElseThrow();
        return null;
    }
}
