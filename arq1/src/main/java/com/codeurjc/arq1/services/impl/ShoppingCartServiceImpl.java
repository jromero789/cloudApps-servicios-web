package com.codeurjc.arq1.services.impl;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.codeurjc.arq1.domain.port.ShoppingCartDto;
import com.codeurjc.arq1.domain.port.ShoppingCartUseCase;
import com.codeurjc.arq1.dtos.request.ShoppingCartRequestDto;
import com.codeurjc.arq1.dtos.response.ShoppingCartResponseDto;
import com.codeurjc.arq1.services.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    
    private Mapper mapper;
    private ShoppingCartUseCase shoppingCartUseCase;

    public ShoppingCartServiceImpl(Mapper mapper, ShoppingCartUseCase shoppingCartUseCase) {
        this.mapper = mapper;
        this.shoppingCartUseCase = shoppingCartUseCase;
    }
    
    @Override
    public ShoppingCartResponseDto findById(Long id) {
        ShoppingCartDto shoppingCartDto = this.shoppingCartUseCase.findById(id);
        return this.mapper.map(shoppingCartDto, ShoppingCartResponseDto.class);
    }

    @Override
    public ShoppingCartResponseDto create(ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCartDto shoppingCartDto = this.mapper.map(shoppingCartRequestDto, ShoppingCartDto.class);
        return this.mapper.map(this.shoppingCartUseCase.create(shoppingCartDto), ShoppingCartResponseDto.class);
    }

    @Override
    public ShoppingCartResponseDto delete(Long id) {
        ShoppingCartDto shoppingCart = this.shoppingCartUseCase.delete(id);
        return this.mapper.map(shoppingCart, ShoppingCartResponseDto.class);
    }

    @Override
    public ShoppingCartResponseDto finishShoppingCart(Long id) {
        return this.mapper.map(this.shoppingCartUseCase.finishShoppingCart(id), ShoppingCartResponseDto.class);
    }

    @Override
    public ShoppingCartResponseDto addProductToShoppingCart(Long cartId, Long prodId, int prodQuantity) {
        return this.mapper.map(this.shoppingCartUseCase.addProductToShoppingCart(cartId, prodId, prodQuantity), ShoppingCartResponseDto.class);
    }

    @Override
    public ShoppingCartResponseDto deleteProduct(Long cartId, Long prodId) {
        return this.mapper.map(this.shoppingCartUseCase.deleteProduct(cartId, prodId), ShoppingCartResponseDto.class);
    }
}
