package com.example.piombo_giulia_project2.controller;

import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.Product;

public class ProductController {

    // inserting a new product
    public void insert (Product product, int quantity) {
        Database.getInstance().insertProduct(product, quantity);
    }

    // getting the product
    public Product getProduct (int index) {
        return Database.getInstance().getProduct(index);
    }

}
