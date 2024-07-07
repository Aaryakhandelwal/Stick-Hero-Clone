package com.example.stickhero3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    public static int highscore=0;

    public static int getHighscore() {
        return highscore;
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            // Open the start screen of the game
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 849, 535);

            //background music
            Music bgm = new Music("C:\\Users\\aarya\\OneDrive\\Desktop\\Stick-Hero-Clone\\Project\\src\\main\\java\\com\\example\\stickhero3\\bgmusic.wav");
            bgm.start();
            // Set title and show the stage
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle the exception
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            // Optionally, show an error message to the user
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading application");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}