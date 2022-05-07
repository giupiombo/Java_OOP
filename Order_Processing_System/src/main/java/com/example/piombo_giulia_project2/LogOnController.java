package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.controller.UserController;
import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class LogOnController {

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    private Stage stage;
    private Scene scene;
    private Parent root;

    UserController userController = new UserController();

    // switching to security question page
    @FXML
    public void switchToLoggedPage (ActionEvent event) throws IOException {

        // logging in
        User loggedUser = userController.logOn(usernameInput.getText(), passwordInput.getText());

        if (loggedUser != null) {

            // setting the logged user
            Database.getInstance().setLoggedUser(loggedUser);

            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("securityQuestion-view.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
