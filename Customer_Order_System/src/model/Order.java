package model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {

    private final String date;
    private final String customerID;
    private final List<Map.Entry<Product, Integer>> items;
    private final int authorizationNumber;
    private final double totalPrice;

    public Order (String customerID, List<Map.Entry<Product, Integer>> items, int authorizationNumber, double totalPrice) {
        this.date = String.valueOf(new Date());
        this.customerID = customerID;
        this.items = items;
        this.authorizationNumber = authorizationNumber;
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public List<Map.Entry<Product, Integer>> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
