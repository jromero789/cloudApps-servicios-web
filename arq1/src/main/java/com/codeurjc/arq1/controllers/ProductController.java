package com.codeurjc.arq1.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeurjc.arq1.dtos.request.ProductRequestDto;
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

    @GetMapping("/{productId}")
    public ProductResponseDto findById(Long id) {
        return this.productService.findById(id);
    }

    @PostMapping("/")
    public ProductResponseDto create(ProductRequestDto product) {
        return this.productService.create(product);
    }

    @PutMapping("/{productId}/stock/{quantity}")
    public ProductResponseDto updateProductStock(int stock) {
        return this.productService.updateStock(stock);
    }

    @DeleteMapping("/{productId}")
    public ProductResponseDto delete(Long id) {
        return this.productService.delete(id);
    }
}
