package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.model.Database;

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

public class InitialMenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button logOnButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button backButton;

    @FXML
    public void switchMenuPressed (ActionEvent event) throws IOException {

        // switching to log on page
        if (event.getSource().equals(logOnButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logOn-view.fxml")));
        }

        // switching to create account page
        else if (event.getSource().equals(createAccountButton)) {

            // seeing if it is a customer or a business profile
            if (Database.getInstance().getSelectTypeOfUser().equals("customer")) {
                root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createAccount-view.fxml")));
            } else if (Database.getInstance().getSelectTypeOfUser().equals("business")) {
                root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createAccountBusiness-view.fxml")));
            }
        }

        // switching to initial selection page
        else if (event.getSource().equals(backButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("initialSelection-view.fxml")));
        }

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
