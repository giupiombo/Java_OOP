package com.example.piombo_giulia_project2.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {
    private final String date;
    private final String customerID;
    private final List<Map.Entry<Product, Integer>> items;
    private final int authorizationNumber;
    private final double totalPrice;
    private String status;

    public Order (String customerID, List<Map.Entry<Product, Integer>> items, int authorizationNumber, double totalPrice,
                  String status) {
        this.date = String.valueOf(new Date());
        this.customerID = customerID;
        this.items = items;
        this.authorizationNumber = authorizationNumber;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // getting the order date
    public String getDate() {
        return date;
    }

    // getting the items in the order
    public List<Map.Entry<Product, Integer>> getItems() {
        return items;
    }

    // making a string for the order
    @Override
    public String toString() {

        StringBuilder outputString = new StringBuilder();

        for (Map.Entry<Product, Integer> item : items) {

            String name = item.getKey().getName();
            Integer quantity = item.getValue();
            int price = item.getKey().getPrice();

            String productInfo = "Name: " + name + " Quantity: " + quantity + " Price: $" + price + "\n";
            outputString.append(productInfo);
        }

        String totalPrice = "\nTotal Price: $" + this.totalPrice;
        outputString.append(totalPrice);

        String orderStatus = "\nOrder Status: " + this.status;
        outputString.append(orderStatus);

        return outputString.toString();
    }

    // setting the order status
    public void setStatus(String status) {
        this.status = status;
    }
}
