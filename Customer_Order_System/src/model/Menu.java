package model;

public class Menu {

    // initial menu
    public void displayInitial () {
        System.out.print("""
                \n--- CUSTOMER ORDER SYSTEM ---
                1. Log On
                2. Create Account
                3. Quit
                Enter your choice (1-3):\s""");
    }

    // menu when the customer has logged in
    public void displayCustomer () {

        System.out.print("""
                \n1. Log Out
                2. Select Items
                3. Make Order
                Enter your choice (1-3):\s""");
    }

    // menu select items
    public void displayMenuSelectItems() {

        Database db = new Database();

        System.out.print("\n--- SELECT ITEMS ---");

        for (Product product : db.getCatalog()) {
            System.out.print("\n" + product.getName() + "\nDescription: " + product.getDescription()
                    + "\nPrice: " + product.getPrice() + "\nSales Price: " + product.getSalesPrice());
            System.out.println("\n+----------------------------------+");
        }

        System.out.print("""
                \n4. End Cart
                Enter your choice (1-4):\s""");
    }

    // menu make order
    public void displayMakeOrder () {
        System.out.print("""
                \n1. Mail by $3 fee
                2. In-store pickup for free
                3. Exit
                Enter your choice (1-3):\s""");
    }

    // menu view order
    public void displayViewOrder () {
        System.out.print("""
                \n1. View Order
                2. Exit
                Enter your choice (1-2):\s""");
    }
}