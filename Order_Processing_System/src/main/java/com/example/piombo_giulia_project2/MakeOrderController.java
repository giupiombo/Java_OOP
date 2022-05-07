package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.controller.BankController;
import com.example.piombo_giulia_project2.controller.OrderController;
import com.example.piombo_giulia_project2.model.Bank;
import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.Order;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MakeOrderController {

    OrderController orderController = new OrderController();
    Bank bank = new Bank();
    BankController bankController = new BankController(bank);

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button mailButton;

    @FXML
    private Button pickupButton;

    // switching to view order page
    @FXML
    public void deliveryMethodPressed (ActionEvent event) throws IOException {

        // getting the user's credit card
        String creditCardNumber = Database.getInstance().getLoggedUser().getCreditCardNumber();
        Order order = null;

        if (event.getSource().equals(mailButton)) {

            int authorizationNumber = bankController.verifyCreditCard(creditCardNumber, "mail");

            // checking if the bank authorized this transaction
            if (authorizationNumber != -1) {
                 order = orderController.create(Database.getInstance().getLoggedUser().getId(), authorizationNumber,
                        "mail");
            }
        }

        // switching to make order page
        else if (event.getSource().equals(pickupButton)) {

            int authorizationNumber = bankController.verifyCreditCard(creditCardNumber, "pickup");

            // checking if the bank authorized this trasaction
            if (authorizationNumber != -1) {
                order = orderController.create(Database.getInstance().getLoggedUser().getId(), authorizationNumber,
                        "pickup");
            }
        }
        Database.getInstance().insertOrder(order);

        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewOrder-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // switching to logged page
    @FXML
    public void backButtonPressed (ActionEvent event) throws IOException {
        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loggedPage-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
