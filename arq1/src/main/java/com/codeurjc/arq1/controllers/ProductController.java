package com.codeurjc.arq1.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeurjc.arq1.dtos.response.ProductResponseDto;
import com.codeurjc.arq1.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private ProductService productService;


    private ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public Collection<ProductResponseDto> getProducts() {
        return this.productService.findAll();
    }

    // @GetMapping("/{productId}")
    // public ProductResponseDto getProductById() {
       
    // }

    // @PostMapping("/")
    // public ProductResponseDto addProduct() {
        
    // }

    //@PutMapping("/{productId}/stock/{quantity}")
    // public ProductResponseDto modifyProductQuantity() {
        
    // }

    //@DeleteMapping("/{productId}")
    // public ProductResponseDto deleteProduct() {
        
    // }
}
