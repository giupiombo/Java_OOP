package model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    private final List<User> users = new ArrayList<>();
    private final List<Product> catalog = new ArrayList<>();
    private final List<Map.Entry<Product, Integer>> cart = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    // creating a database to store initial values in user and catalog
    public Database () {
        // setting an initial user
        this.users.add(new User("giupiombo", "Piombo$24", "Giulia", "21Hundred", "2839-3748-2748-7394",
                "1. What is the name of your pet", "Stella"));

        // setting the catalog of products
        this.catalog.add(new Product("1. iPhone 13",
                "The iPhone is a smartphone made by Apple that combines a computer, iPod, digital camera and cellular phone into one device with a touchscreen interface.",
                999,
                799));
        this.catalog.add(new Product("2. Apple Watch Series 7",
                "Apple Watch is a wearable smartwatch that allows users to accomplish a variety of tasks, including making phone calls, sending text messages and reading email.",
                449,
                349));
        this.catalog.add(new Product("3. AirPods 3rd Generation",
                "AirPods are wireless Bluetooth earbuds designed by Apple Inc.",
                179,
                100));
    }

    // inserting a new user
    public void insertUser (User user) {
        this.users.add(user);
    }

    // inserting a new product
    public void insertProduct (Product product, int quantity) {
        Map.Entry<Product,Integer> entry = new AbstractMap.SimpleEntry<>(product, quantity);
        this.cart.add(entry);
    }

    // inserting a new order
    public void insertOrder (Order order) {
        this.orders.add(order);
    }

    public Product getProduct (int index) {
        return this.catalog.get(index);
    }

    public List<User> getUsers (){
        return this.users;
    }

    public List<Product> getCatalog() { return  this.catalog; }

    public List<Map.Entry<Product, Integer>> getCart() {
        return this.cart;
    }
}