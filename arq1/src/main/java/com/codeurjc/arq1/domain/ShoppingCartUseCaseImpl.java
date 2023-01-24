package com.codeurjc.arq1.domain;

import org.dozer.Mapper;

import com.codeurjc.arq1.domain.port.ProductDto;
import com.codeurjc.arq1.domain.port.ProductRepository;
import com.codeurjc.arq1.domain.port.ShoppingCartDto;
import com.codeurjc.arq1.domain.port.ShoppingCartRepository;
import com.codeurjc.arq1.domain.port.ShoppingCartUseCase;
import java.util.Objects;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {

    private ShoppingCartRepository shoppingCartRepository;
    private ProductRepository productRepository;
    private Mapper mapper;


    public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository,
            Mapper mapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public ShoppingCartDto findById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public ShoppingCartDto create(ShoppingCartDto shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCartDto delete(Long id) {
        ShoppingCartDto shoppingCart = shoppingCartRepository.findById(id);
        shoppingCartRepository.delete(id);
        return shoppingCart;
    }

    @Override
    public ShoppingCartDto finishShoppingCart(Long id) {
        ShoppingCartDto shoppingCartDto = shoppingCartRepository.findById(id);
        // TODO: Add validation logic
        return shoppingCartRepository.save(shoppingCartDto);
    }

    @Override
    public ShoppingCartDto addProductToShoppingCart(Long cartId, Long prodId, int prodQuantity) {
        ShoppingCartDto shoppingCartDto = shoppingCartRepository.findById(cartId);
        ProductDto productDto = productRepository.findById(cartId);
        shoppingCartDto.getProducts().add(productDto);
        return shoppingCartRepository.save(shoppingCartDto);
    }

    @Override
    public ShoppingCartDto deleteProduct(Long cartId, Long prodId) {
        ShoppingCartDto shoppingCartDto = shoppingCartRepository.findById(cartId);
        shoppingCartDto.getProducts().removeIf(x -> Objects.equals(x.getId(), prodId)); 
        return shoppingCartRepository.save(shoppingCartDto);
    }
    
    
}
