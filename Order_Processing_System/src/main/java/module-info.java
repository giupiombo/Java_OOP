module com.example.piombo_giulia_project2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.piombo_giulia_project2 to javafx.fxml;
    exports com.example.piombo_giulia_project2;
    exports com.example.piombo_giulia_project2.model;
    opens com.example.piombo_giulia_project2.model to javafx.fxml;
}