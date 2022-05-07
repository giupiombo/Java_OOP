package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.Order;
import com.example.piombo_giulia_project2.model.Product;
import com.example.piombo_giulia_project2.model.Stock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProcessOrderController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label date;

    @FXML
    private Label products;

    @FXML
    private CheckBox order;

    // displaying orders
    @FXML
    public  void initialize () {
        if (Database.getInstance().getOrder() != null) {
            date.setText("Date: " + Database.getInstance().getOrder().getDate());
            products.setText(Database.getInstance().getOrder().toString());
        }
    }

    // reserving items
    @FXML
    public void processOrderPressed (ActionEvent event) throws IOException {

        if (order.isSelected()) {

            Order order = Database.getInstance().getOrder();
            List<Stock> stockItems = Database.getInstance().getStockList();
            boolean status = true;

            // for loop to see if there is enough items available to proceed with the order
            for (Stock stock : stockItems) {
                for (Map.Entry<Product, Integer> item : order.getItems()) {
                    if (stock.getName().equals(item.getKey().getName())) {
                        if (stock.getAvailableQuantity() < item.getValue()) {
                            status = false;
                            break;
                        } else {
                            // setting the reserved quantity to the quantity ordered
                            stock.setReservedQuantity(item.getValue());

                            // setting the available quantity to what is left
                            stock.setAvailableQuantity(stock.getAvailableQuantity()- item.getValue());
                        }
                    }
                }
            }

            // if there is enough items in stock
            if (status) {
                // changing the order status and going to view order page
                order.setStatus("ready");
                root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewOrder-view.fxml")));
            } else {
                // going to warning view
                root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("warning-view.fxml")));
            }

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

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
