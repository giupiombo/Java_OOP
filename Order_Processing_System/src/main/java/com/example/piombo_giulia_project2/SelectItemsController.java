package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.controller.CartController;
import com.example.piombo_giulia_project2.controller.ProductController;
import com.example.piombo_giulia_project2.model.Product;

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

public class SelectItemsController {

    @FXML
    private CheckBox iphone;

    @FXML
    private CheckBox watch;

    @FXML
    private CheckBox airpods;

    @FXML
    private TextField iphoneQuantity;

    @FXML
    private TextField watchQuantity;

    @FXML
    private TextField airpodsQuantity;

    private Stage stage;
    private Scene scene;
    private Parent root;

    ProductController productController = new ProductController();
    CartController cartController = new CartController();

    // switching to logged page
    @FXML
    public void switchToEndCart (ActionEvent event) throws IOException {

        // inserting products to the cart
        if (iphone.isSelected()) {
            Product chosenProduct = productController.getProduct(0);
            productController.insert(chosenProduct, Integer.parseInt(iphoneQuantity.getText()));
        }
        if (watch.isSelected()) {
            Product chosenProduct = productController.getProduct(1);
            productController.insert(chosenProduct, Integer.parseInt(watchQuantity.getText()));
        }
        if (airpods.isSelected()) {
            Product chosenProduct = productController.getProduct(2);
            productController.insert(chosenProduct, Integer.parseInt(airpodsQuantity.getText()));
        }

        // creating the cart
        cartController.create();

        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loggedPage-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
