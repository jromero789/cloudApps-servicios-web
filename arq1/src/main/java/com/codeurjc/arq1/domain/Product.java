package com.codeurjc.arq1.domain;

public class Product {
    
    private Long id;
    private String brand;
    private String name;
    private int stock;

    public Product() {
    }

    void updateStock(int stock){
        this.stock = stock;
    }

    
}
