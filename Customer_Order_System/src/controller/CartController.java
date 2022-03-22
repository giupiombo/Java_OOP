package controller;

import model.Database;
import model.Product;

import java.util.List;
import java.util.Map;

public class CartController {

    private final Database db;

    public CartController (Database db) {
        this.db = db;
    }

    // getting the cart
    public List<Map.Entry<Product, Integer>> getCart() {
        return db.getCart();
    }

    // calculating the cart
    public double create () {

        List<Map.Entry<Product, Integer>> cart = this.getCart();
        double sumPrices = 0;

        // printing the cart
        System.out.println("+----------------------------------+\n");
        for (Map.Entry<Product, Integer> productIntegerEntry : cart) {
            System.out.println("Name: " + productIntegerEntry.getKey().getName() + "\nQuantity: " + productIntegerEntry.getValue() +
                    "\nUnitary Price: $" + productIntegerEntry.getKey().getPrice());
            sumPrices += productIntegerEntry.getKey().getPrice()*productIntegerEntry.getValue();
        }

        // calculating taxes and final price
        System.out.println("Taxes (10%): $" + sumPrices*0.1 + "\nTotal Price: $" + sumPrices*1.1);

        System.out.println("\n+----------------------------------+");

        return sumPrices*1.1;
    }
}
