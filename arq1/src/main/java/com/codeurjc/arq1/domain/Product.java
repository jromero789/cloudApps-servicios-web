package com.codeurjc.arq1.domain;

public class Product {
    
    private Long id;
    private String brand;
    private String name;
    private int stock;

    public Product() {
    }

    private void reduceStock(){
        this.stock -= 1;
    }

    
}
