package com.codeurjc.arq1.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.Mapper;

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
    public List<ShoppingCartDto> findAll() {
        List<ShoppingCartEntity> shoppingCarts = shoppingCartJpaRepository.findAll();
		
		return shoppingCarts
				.stream()
				.map(p -> mapper.map(p, ShoppingCartDto.class))
				.collect(Collectors.toList());
    }

    @Override
    public ShoppingCartDto findById(Long id) {
        ShoppingCartEntity shoppingCartEntity = shoppingCartJpaRepository.findById(id).orElseThrow();
		return mapper.map(shoppingCartEntity, ShoppingCartDto.class);
    }

    @Override
	public ShoppingCartDto save(ShoppingCartDto shoppingCart) {
		
		ShoppingCartEntity shoppingCartEntity = mapper.map(shoppingCart, ShoppingCartEntity.class);
		ShoppingCartEntity savedShoppingCartEntity = shoppingCartJpaRepository.save(shoppingCartEntity);
		
		return mapper.map(savedShoppingCartEntity, ShoppingCartDto.class);
	}

    @Override
    public Optional<ShoppingCartDto> delete(Long id) {

        Optional<ShoppingCartEntity> maybeAShoppingCart = shoppingCartJpaRepository.findById(id);		
		return maybeAShoppingCart.map(b -> mapper.map(b, ShoppingCartDto.class));
    }
}
