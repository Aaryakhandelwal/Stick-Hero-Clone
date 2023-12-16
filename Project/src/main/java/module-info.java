module com.example.stickhero3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires org.junit.jupiter.api;
    requires java.desktop;


    opens com.example.stickhero3 to javafx.fxml;
    exports com.example.stickhero3;
}