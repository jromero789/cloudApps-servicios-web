package com.codeurjc.arq1.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeurjc.arq1.dtos.request.ShoppingCartRequestDto;
import com.codeurjc.arq1.dtos.response.ShoppingCartResponseDto;
import com.codeurjc.arq1.services.ShoppingCartService;

@RestController
@RequestMapping("api/shoppingcarts")
public class ShoppingCartController {
    
    private ShoppingCartService shoppingCartService;


    private ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{id}")
    public ShoppingCartResponseDto getShoppingCartById(Long id) {
        return this.shoppingCartService.findById(id);
    }

    @PostMapping("/")
    public ShoppingCartResponseDto create(ShoppingCartRequestDto shoppingCart) {
        return this.shoppingCartService.create(shoppingCart);
    }

    @DeleteMapping("/{id}")
    public ShoppingCartResponseDto delete(Long id) {
        return this.shoppingCartService.delete(id);
    }

    @PatchMapping("/{id}")
    public ShoppingCartResponseDto finishShoppingCart(Long id){
        return this.shoppingCartService.finishShoppingCart(id);
    }

    @PostMapping("/{cart_id}/product/{prod_id}/quantity/{prod_quantity}")
    public ShoppingCartResponseDto addProductToShoppingCart(Long cart_id, Long prod_id, int prod_quantity){
        return this.shoppingCartService.addProductToShoppingCart(cart_id, prod_id, prod_quantity);
    }   

    @DeleteMapping("/{cart_id}/product/{prod_id}")
    public ShoppingCartResponseDto deleteProduct(Long cart_id, Long prod_id) {
        return this.shoppingCartService.deleteProduct(cart_id, prod_id);
    }
}

