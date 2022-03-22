package model;

public class Product {

    private final String name;
    private final String description;
    private final int price;
    private final int salesPrice;

    public Product(String name, String description, int price, int salesPrice) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.salesPrice = salesPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getSalesPrice() {
        return salesPrice;
    }
}