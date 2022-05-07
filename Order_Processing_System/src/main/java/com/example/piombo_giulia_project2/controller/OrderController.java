package com.example.piombo_giulia_project2.controller;

import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.Order;

public class OrderController {

    CartController cartController = new CartController();

    // create a new order
    public Order create (String customerID, int authorizationNumber, String delivery) {
        Order order;

        if (delivery.equals("mail")) {
            order = new Order(customerID, Database.getInstance().getCart(), authorizationNumber,
                    cartController.create()+3, "ordered");
        } else {
            order = new Order(customerID, Database.getInstance().getCart(), authorizationNumber,
                    cartController.create(), "ordered");
        }

        Database.getInstance().insertOrder(order);
        return order;
    }
}
