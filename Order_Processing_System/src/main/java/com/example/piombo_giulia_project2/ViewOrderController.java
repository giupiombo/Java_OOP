package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.model.Database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ViewOrderController {

    @FXML
    private Label date;

    @FXML
    private Label products;

    private Stage stage;
    private Scene scene;
    private Parent root;

    // displaying the order
    @FXML
    public  void initialize () {
        if (Database.getInstance().getOrder() != null) {
            date.setText("Date: " + Database.getInstance().getOrder().getDate());
            products.setText(Database.getInstance().getOrder().toString());
        }
    }

    // switching to logged page
    @FXML
    public void backButtonPressed (ActionEvent event) throws IOException {

        // checking if it is a customer or a business profile
        if (Database.getInstance().getSelectTypeOfUser().equals("customer")) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loggedPage-view.fxml")));
        } else if (Database.getInstance().getSelectTypeOfUser().equals("business")) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loggedPageBusiness-view.fxml")));
        }

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
