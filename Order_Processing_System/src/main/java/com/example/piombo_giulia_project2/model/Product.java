package com.example.piombo_giulia_project2.model;

public class Product {
    private final String name;
    private final String description;
    private final int price;
    private final int salesPrice;

    public Product(String name, String description, int price, int salesPrice) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.salesPrice = salesPrice;
    }

    // getting the product name
    public String getName() {
        return name;
    }

    // getting the product price
    public int getPrice() {
        return price;
    }
}
