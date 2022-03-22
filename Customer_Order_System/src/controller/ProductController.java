package controller;

import model.Database;
import model.Product;

public class ProductController {

    private final Database db;

    public ProductController (Database db) {
        this.db = db;
    }

    // inserting a new product
    public void insert (Product product, int quantity) {
        this.db.insertProduct(product, quantity);
    }

    // getting the product
    public Product getProduct (int index) {
        return this.db.getProduct(index);
    }
}
