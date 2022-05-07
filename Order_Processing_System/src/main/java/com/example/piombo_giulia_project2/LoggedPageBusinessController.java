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

public class LoggedPageBusinessController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button processOrderButton;

    @FXML
    private Button shipOrderButton;

    @FXML
    private Button viewStockButton;

    @FXML
    private Button logOutButton;

    @FXML
    public void switchLoggedPressed (ActionEvent event) throws IOException {

        // switching to process order page
        if (event.getSource().equals(processOrderButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("processOrder-view.fxml")));
        }

        // switching to ship order page
        else if (event.getSource().equals(shipOrderButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("shipOrder-view.fxml")));
        }

        // switching to view stock page
        else if (event.getSource().equals(viewStockButton)) {
            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewStock-view.fxml")));
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
