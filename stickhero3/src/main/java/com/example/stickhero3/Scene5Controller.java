package com.example.stickhero3;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene5Controller {
    @FXML Stage stage;
    @FXML Scene scene;
    @FXML ActionEvent event;

    @FXML
    Label score;
    @FXML
    Label highScore;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ActionEvent getEvent() {
        return event;
    }

    public void setEvent(ActionEvent event) {
        this.event = event;
    }

    public Label getScore() {
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }

    public Label getHighScore() {
        return highScore;
    }

    public void setHighScore(Label highScore) {
        this.highScore = highScore;
    }
// Other fields and methods...

    // Method to set the totalScore in the controller
    public void setTotalScore(int totalScore) {
        // Update the label with the totalScore
        score.setText(String.valueOf(totalScore));
    }

    public void setHighScore(int sc) {
        // Update the label with the totalScore
        highScore.setText(String.valueOf(HelloApplication.highscore));
    }
    public void restartGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        this.event = event;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}