import controller.*;
import model.*;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Database db = new Database();
        Bank bank = new Bank();
        Menu menu = new Menu();

        BankController bankController = new BankController(bank);
        CartController cartController = new CartController(db);
        OrderController orderController = new OrderController(db, cartController);
        ProductController productController = new ProductController(db);
        UserController userController = new UserController(db);

        // displaying initial display
        menu.displayInitial();
        int choiceInitial = sc.nextInt();

        while (choiceInitial != 3) {

            // log on
             if (choiceInitial == 1) {

                // verifying user
                User loggedUser = userController.logOn();

                if (loggedUser != null) {

                    // displaying menu when logged
                    menu.displayCustomer();
                    int choiceLogged = sc.nextInt();

                    // variable to store the total price of the cart
                    double totalPriceCart = 0;

                    while (choiceLogged != 1) {

                        // select items
                        if (choiceLogged == 2) {

                            // displaying menu
                            menu.displayMenuSelectItems();
                            int choiceSelectItem = sc.nextInt();

                            while (choiceSelectItem != 4) {

                                // requesting for the quantity of the item chosen
                                System.out.print("Quantity: ");
                                int quantity = sc.nextInt();

                                // setting the cart
                                Product chosenProduct = productController.getProduct(choiceSelectItem-1);
                                productController.insert(chosenProduct, quantity);

                                // displaying menu
                                menu.displayMenuSelectItems();
                                choiceSelectItem = sc.nextInt();
                            }

                            // getting the total price
                            totalPriceCart = cartController.create();

                            // displaying menu
                            menu.displayCustomer();
                            choiceLogged = sc.nextInt();
                        }

                        // make order
                        if (choiceLogged == 3) {

                            // displaying menu
                            menu.displayMakeOrder();
                            int choiceMakeOrder = sc.nextInt();

                            // exit
                            while (choiceMakeOrder != 3) {

                                double totalPriceCartDelivery = 0;

                                // mail delivery
                                if (choiceMakeOrder == 1) {
                                    totalPriceCartDelivery = totalPriceCart+3;
                                    System.out.println("Total Price with Delivery Fee: $" + totalPriceCartDelivery);
                                }

                                // pickup
                                else if (choiceMakeOrder == 2) {
                                    totalPriceCartDelivery = totalPriceCart;
                                    System.out.println("Total Price with Free In-Store Pickup: $" + totalPriceCartDelivery);
                                }

                                // invalid input
                                else {
                                    System.out.println("Invalid input!");
                                }

                                // storing the customer's credit card number
                                String creditCardNumber = loggedUser.getCreditCardNumber();
                                int authorizationNumber = bankController.verifyCreditCard(creditCardNumber, totalPriceCartDelivery);

                                if (authorizationNumber != -1) {
                                    System.out.println("Card verified!" + "\nOrder created successfully!");

                                    Order order = orderController.create(loggedUser.getId(), authorizationNumber, totalPriceCart);

                                    // displaying menu
                                    menu.displayViewOrder();
                                    int choiceViewOrder = sc.nextInt();

                                    while (choiceViewOrder != 2) {

                                        // display order
                                        if (choiceViewOrder == 1) {
                                            orderController.display(order);
                                        } else {
                                            System.out.println("Invalid Input!");
                                        }

                                        // displaying menu
                                        menu.displayViewOrder();
                                        choiceViewOrder = sc.nextInt();
                                    }
                                } else {

                                    // storing a new credit card number
                                    Account currentAccount = bankController.getAccount(creditCardNumber);
                                    System.out.println("The balance in this account is of: " + currentAccount.getBalance());
                                    System.out.println("""
                                            Invalid card!
                                            Please enter a new credit card:\s""");

                                    creditCardNumber = sc.next();
                                    loggedUser.setCreditCardNumber(creditCardNumber);

                                    // verifying the new card
                                    authorizationNumber = bankController.verifyCreditCard(creditCardNumber, totalPriceCartDelivery);
                                }

                                // displaying menu
                                menu.displayMakeOrder();
                                choiceMakeOrder = sc.nextInt();
                            }
                        }

                        else {
                            System.out.println("Invalid input!");
                        }

                        // displaying menu
                        menu.displayCustomer();
                        choiceLogged = sc.nextInt();
                    }
                } else {
                    break;
                }
            }

            // create account
            else if (choiceInitial == 2) {

                // storing the new user
                User newUser = userController.create();
                userController.save(newUser);

                // creating a new account with a random balance
                bankController.createAccount(newUser.getCreditCardNumber());
            }

            // check for valid input
             else {
                System.out.println("Not a valid input!");
            }

            // displaying menu
            menu.displayInitial();
            choiceInitial = sc.nextInt();
        }
    }
}