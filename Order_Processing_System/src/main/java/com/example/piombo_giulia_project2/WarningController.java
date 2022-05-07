package com.example.piombo_giulia_project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class WarningController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // switching to logged page
    @FXML
    public void switchToLoggedPageBusiness (ActionEvent event) throws IOException {
        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loggedPageBusiness-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
