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

public class InitialSelectionController {

    @FXML
    private Button customerButton;

    @FXML
    private Button businessButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    // switching to initial menu page
    @FXML
    public void switchToInitialMenu (ActionEvent event) throws IOException {

        // setting the type of user in database to the one chosen
        if (event.getSource().equals(customerButton)) {
            Database.getInstance().setSelectTypeOfUser("customer");
        } else if (event.getSource().equals(businessButton)) {
            Database.getInstance().setSelectTypeOfUser("business");
        }

        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("initialMenu-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // exit the program
    @FXML
    public void exitPressed (ActionEvent event) {
        System.exit(0);
    }
}
