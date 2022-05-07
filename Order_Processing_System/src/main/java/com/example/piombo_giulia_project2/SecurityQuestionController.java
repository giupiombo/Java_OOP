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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SecurityQuestionController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    UserController userController = new UserController();

    @FXML
    private TextField answerInput;

    @FXML
    private Label question;

    // displaying the security question
    @FXML
    public void initialize () {
        question.setText(Database.getInstance().getLoggedUser().getSecurityQuestion());
    }

    // switching to logged page
    @FXML
    public void switchToLoggedPage (ActionEvent event) throws IOException {

        // verifying the security answer
        boolean verifySecurityAnswer = userController.verifySecurityAnswer(answerInput.getText());

        if (verifySecurityAnswer) {

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
}
