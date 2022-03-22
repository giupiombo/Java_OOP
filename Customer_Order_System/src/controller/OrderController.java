package controller;

import model.Database;
import model.Order;
import model.Product;

import java.util.Map;

public class OrderController {

    private final Database db;
    private final CartController cartController;

    public OrderController (Database db, CartController cartController) {
        this.db = db;
        this.cartController = cartController;
    }

    // create a new order
    public Order create (String customerID, int authorizationNumber, double totalPrice) {
        Order order = new Order(customerID, this.cartController.getCart(), authorizationNumber, totalPrice);
        this.db.insertOrder(order);
        return order;
    }

    // display the order made
    public void display (Order order) {
        System.out.println("\n--- ORDER DETAILS ---");
        System.out.println("Date: " + order.getDate());
        for (Map.Entry<Product, Integer> product : order.getItems()) {
            System.out.println("Name: " + product.getKey().getName() + "\nQuantity: " + product.getValue());
        }
        System.out.println("Total Price: $" + order.getTotalPrice());
    }
}