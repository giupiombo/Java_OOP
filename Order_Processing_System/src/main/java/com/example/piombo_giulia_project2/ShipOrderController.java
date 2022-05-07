package com.example.piombo_giulia_project2;

import com.example.piombo_giulia_project2.model.Database;
import com.example.piombo_giulia_project2.model.Order;
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
import java.util.Objects;

public class ShipOrderController {

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

    // switching to view order page
    @FXML
    public void shipOrderPressed (ActionEvent event) throws IOException {

        if (order.isSelected()) {

            Order order = Database.getInstance().getOrder();
            List<Stock> stockItems = Database.getInstance().getStockList();

            // setting the new total and reserved quantity
            for (Stock stock : stockItems) {
                stock.setTotalQuantity(stock.getTotalQuantity()- stock.getReservedQuantity());
                stock.setReservedQuantity(0);
            }

            // changing the order status to shipped
            order.setStatus("shipped");

            root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("viewOrder-view.fxml")));
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
