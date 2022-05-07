package com.example.piombo_giulia_project2.controller;

import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.Product;

import java.util.List;
import java.util.Map;

public class CartController {

    // getting the cart
    public List<Map.Entry<Product, Integer>> getCart() {
        return Database.getInstance().getCart();
    }

    // calculating the cart
    public double create () {
        List<Map.Entry<Product, Integer>> cart = this.getCart();
        double sumPrices = 0;

        for (Map.Entry<Product, Integer> productIntegerEntry : cart) {
            sumPrices += productIntegerEntry.getKey().getPrice()*productIntegerEntry.getValue();
        }
        return sumPrices*1.1;
    }
}
