package com.example.piombo_giulia_project2;

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

public class LoggedPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button selectItemsButton;

    @FXML
    private Button makeOrderButton;

    @FXML
    private Button viewOrder;

    @FXML
    private Button logOutButton;

    @FXML
    public void switchLoggedPressed (ActionEvent event) throws IOException {

        // switching to select items page
        if (event.getSource().equals(selectItemsButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("selectItems-view.fxml")));
        }

        // switching to make order page
        else if (event.getSource().equals(makeOrderButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("makeOrder-view.fxml")));
        }

        // switching to view order page
        else if (event.getSource().equals(viewOrder)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewOrder-view.fxml")));
        }

        // switching to initial selection page
        else if (event.getSource().equals(logOutButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("initialSelection-view.fxml")));
        }

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
