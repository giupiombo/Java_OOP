package com.example.piombo_giulia_project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        // Displaying the initial selection menu
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("initialSelection-view.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle("Order Processing System");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}