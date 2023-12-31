module com.example.kwadrat_logiczny {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;


    opens com.example.kwadrat_logiczny to javafx.fxml;
    exports com.example.kwadrat_logiczny;
}