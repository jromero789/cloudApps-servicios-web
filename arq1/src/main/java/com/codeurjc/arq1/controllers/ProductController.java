package com.codeurjc.arq1.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
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




}
