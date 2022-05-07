package com.example.piombo_giulia_project2.model;

public class Stock {
    String name;
    int totalQuantity;
    int availableQuantity;
    int reservedQuantity;

    public Stock (String name, int totalQuantity) {
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = totalQuantity - reservedQuantity;
    }

    // getting the product name
    public String getName() {
        return name;
    }

    // getting the total quantity of the product
    public int getTotalQuantity() {
        return totalQuantity;
    }

    // getting the available quantity of the product
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    // getting the reserved quantity of the product
    public int getReservedQuantity() {
        return reservedQuantity;
    }

    // setting the reserved quantity when an order has been processed or shipped
    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    // setting the available quantity when an order has been processed or shipped
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    // setting the total quantity when an order has been shipped
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
