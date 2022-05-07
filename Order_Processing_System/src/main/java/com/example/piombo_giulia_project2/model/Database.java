package com.example.piombo_giulia_project2.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    private final List<User> usersCustomer = new ArrayList<>();
    private final List<User> usersBusiness = new ArrayList<>();
    private final List<Product> catalog = new ArrayList<>();
    private final List<Stock> stockList = new ArrayList<>();
    private final List<Map.Entry<Product, Integer>> cart = new ArrayList<>();
    private Order order;
    private User loggedUser;
    private String selectTypeOfUser;

    // database instance to be accessed everywhere
    private static Database instance = new Database();

    public static Database getInstance() {
        return instance;
    }

    // customer or business
    public void setSelectTypeOfUser(String selectTypeOfUser) {
        this.selectTypeOfUser = selectTypeOfUser;
    }

    public String getSelectTypeOfUser () {
        return this.selectTypeOfUser;
    }

    // creating a database to store initial values in users, catalog and stock
    private Database () {
        // setting an initial customer user
        this.usersCustomer.add(new User("giupiombo", "Piombo$24", "Giulia", "21Hundred",
                "2839-3748-2748-7394", "What is the name of your pet?", "Stella"));

        // setting an initial business user
        this.usersBusiness.add(new User("john", "JohnDoe@2", "John", "UClub",
                "What is your hometown?", "Lubbock"));

        // setting the catalog of products
        this.catalog.add(new Product("iPhone 13",
                "The iPhone is a smartphone made by Apple that combines a computer, iPod, digital camera and cellular phone into one device with a touchscreen interface.",
                999,
                799));
        this.catalog.add(new Product("Apple Watch Series 7",
                "Apple Watch is a wearable smartwatch that allows users to accomplish a variety of tasks, including making phone calls, sending text messages and reading email.",
                449,
                349));
        this.catalog.add(new Product("AirPods 3rd Generation",
                "AirPods are wireless Bluetooth earbuds designed by Apple Inc.",
                179,
                100));

        // setting the stock
        this.stockList.add(new Stock("iPhone 13", 3));
        this.stockList.add(new Stock("Apple Watch Series 7", 5));
        this.stockList.add(new Stock("AirPods 3rd Generation", 10));

    }

    // inserting a new user
    public void insertUser (User user) {
        if (this.selectTypeOfUser.equals("customer")){
            this.usersCustomer.add(user);
        } else if (this.selectTypeOfUser.equals("business")){
            this.usersBusiness.add(user);
        }
    }

    // inserting a new product
    public void insertProduct (Product product, int quantity) {
        Map.Entry<Product,Integer> entry = new AbstractMap.SimpleEntry<>(product, quantity);
        this.cart.add(entry);
    }

    // inserting a new order
    public void insertOrder (Order order) {
        this.order = order;
    }

    // getting the product from catalog
    public Product getProduct (int index) {
        return this.catalog.get(index);
    }

    // getting the customer user
    public List<User> getUsersCustomer(){
        return this.usersCustomer;
    }

    // getting the business user
    public List<User> getUsersBusiness(){
        return this.usersBusiness;
    }

    // getting the cart
    public List<Map.Entry<Product, Integer>> getCart() {
        return this.cart;
    }

    // setting the logged user
    public void setLoggedUser (User loggedUser) {
        this.loggedUser = loggedUser;
    }

    // getting the logged user
    public User getLoggedUser () {
        return this.loggedUser;
    }

    // getting the order
    public Order getOrder () {return this.order;}

    // getting the stock
    public List<Stock> getStockList() {
        return stockList;
    }

    // returning the stock items and quantities
    public String stockListToString() {

        StringBuilder outputString = new StringBuilder();

        for (Stock item : stockList) {

            String name = item.getName();
            int totalQuantity = item.getTotalQuantity();
            int availableQuantity = item.getAvailableQuantity();
            int reservedQuantity = item.getReservedQuantity();

            String productInfo = "Name: " + name + " Total Quantity: " + totalQuantity + " Available Quantity: " +
                    availableQuantity + " Reserved Quantity: " + reservedQuantity + "\n";
            outputString.append(productInfo);
        }

        return outputString.toString();
    }
}
