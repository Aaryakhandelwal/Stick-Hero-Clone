package com.example.stickhero3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;

public class Scene3Controller {
    @FXML public Button restart;
    @FXML public Button resume;
    @FXML public Button save;
    @FXML ActionEvent event;
    @FXML Scene scene;
    @FXML Stage stage;
    private Game game=null;
    @FXML
    Label score;

    private void deserializeGame(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\aarya\\OneDrive\\Desktop\\STICK-HERO\\Stick-Hero-Game\\stickhero3\\src\\main\\resources\\com\\example\\stickhero3\\gameState.ser"))) {
            game = (Game) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void resumeGame(ActionEvent event) throws IOException{
        deserializeGame();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        Parent root = loader.load();
        Scene1Controller scene1Controller = loader.getController();
        scene1Controller.setScore(game.getPlayerScore());
        scene1Controller.setRewards(game.getPlayerRewards());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void restartGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        this.event = event;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void saveGame(ActionEvent event) throws IOException{
        serializeSavedGame();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void serializeSavedGame(){
        deserializeGame();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\aarya\\OneDrive\\Desktop\\STICK-HERO\\Stick-Hero-Game\\stickhero3\\src\\main\\resources\\com\\example\\stickhero3\\savedGameState.ser"))) {
            oos.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setTotalScore(int totalScore) {
        // Update the label with the totalScore
        score.setText(String.valueOf(totalScore));
    }

    public Button getRestart() {
        return restart;
    }

    public void setRestart(Button restart) {
        this.restart = restart;
    }

    public Button getResume() {
        return resume;
    }

    public void setResume(Button resume) {
        this.resume = resume;
    }

    public Button getSave() {
        return save;
    }

    public void setSave(Button save) {
        this.save = save;
    }

    public ActionEvent getEvent() {
        return event;
    }

    public void setEvent(ActionEvent event) {
        this.event = event;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Label getScore() {
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }


}
