package com.codeurjc.arq1.dtos.request;

public class ProductRequestDto {

    private String brand;
    private String name;
    private Number stock;

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Number getStock() {
        return stock;
    }
    public void setStock(Number stock) {
        this.stock = stock;
    }

}