package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.controller.UserController;
import com.example.piombo_giulia_project2.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class CreateAccountBusinessController {

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField addressInput;

    @FXML
    private CheckBox question1;

    @FXML
    private CheckBox question2;

    @FXML
    private CheckBox question3;

    @FXML
    private TextField answer;

    private Stage stage;
    private Scene scene;
    private Parent root;

    //    Database db = new Database();
    UserController userController = new UserController();

    public String question () {
        if (question1.isSelected()) {
            return question1.getText();
        } else if (question2.isSelected()) {
            return question2.getText();
        } else if (question3.isSelected()) {
            return question3.getText();
        } else {
            return null;
        }
    }

    // switching to log on page
    @FXML
    public void switchToLogOn (ActionEvent event) throws IOException {

        // setting the selected question
        String selectedQuestion = question();

        // creating a new user
        User newUser = userController.create(usernameInput.getText(), passwordInput.getText(), nameInput.getText(),
                addressInput.getText(), selectedQuestion, answer.getText());
        userController.save(newUser);

        // if new user is created, change to log on page
        if (newUser != null) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logOn-view.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
