package com.example.stickhero3;

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.security.Key;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Random;

public class Scene1Controller {


    private Stick Stick;
    private Avatar Avatar;
    private Game game = new Game(0, 0);
    private int totalScore = 0;
    private int totalHighScore = 0;
    @FXML
    private Label score;
    @FXML
    private Label highscore;
    @FXML
    private Label rewards;
    @FXML
    private Button start;
    private Stage stage;
    private Scene scene;
    @FXML
    private Rectangle stick;
    @FXML
    AnchorPane anchorPane2;
    @FXML
    private ImageView avatar;
    @FXML
    private Rectangle pillar1;
    @FXML
    private Rectangle pillar2;
    @FXML private Rectangle midpoint;

    private ActionEvent event;

    public ImageView getAvatar() {
        return avatar;
    }

    public Rectangle getPillar1() {
        return pillar1;
    }

    public Rectangle getPillar2() {
        return pillar2;
    }

    private void setup() {
//        Stick = com.example.stickhero3.Stick.getInstance(stick);
//        Avatar = com.example.stickhero3.Avatar.getInstance(avatar);
//        Stick.setup();
//        Avatar.setup();
    }

    public void startGame(ActionEvent event) throws IOException {

        FXMLLoader file = new FXMLLoader(getClass().getResource("scene2.fxml" ));
        Parent root = file.load();
        Scene1Controller scene1Controller = file.getController();
        scene1Controller.setup();
        this.event = event;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void setScore(int sc) {
        totalScore = sc;
        score.setText((String.valueOf(sc)));
        game.setPlayerScore(sc);
    }

    public void setRewards(int rew) {
        rewards.setText((String.valueOf(rew)));
        game.setPlayerRewards(rew);
    }


    public int flag = 0;
    private boolean isResizing = false;
    private Timeline timeline;


    @FXML
    public void stopStick() {
        flag = 1;
        timeline.stop();
        rotateStick();
        isResizing = false;
        flag = 0;
    }

    @FXML
    public void extendStick() {
        if (flag == 0) {
            isResizing = true;
            // Set the duration for the keyframe (e.g., 50 milliseconds)
            Duration keyFrameDuration = Duration.millis(50);
            timeline = new Timeline(
                    new KeyFrame(keyFrameDuration, event -> extend())
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    private void rotateStick() {
        Rotate rotate = new Rotate();
        rotate.setPivotX(stick.getX());
        rotate.setPivotY(stick.getY() + stick.getHeight());
        stick.getTransforms().add(rotate);
        rotate.setAngle(90);
        moveAvatar();
    }


    public void extend() {
        if (flag == 0) {
            double newY = stick.getY() - 5;
            double newHeight = stick.getHeight() + 5;
            stick.setY(newY);
//                Stick.setHeight(newHeight);
            stick.setHeight(newHeight);

        }

    }

    void displayGameOverScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene5.fxml" ));
        Parent root = loader.load();
        Scene5Controller scene5Controller = loader.getController();
        scene5Controller.setTotalScore(totalScore);
        if (totalScore > HelloApplication.highscore) {
            HelloApplication.highscore = totalScore;
        }
        scene5Controller.setHighScore(HelloApplication.highscore);
        stage = new Stage();
        stage.setTitle("GameOver" );
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void serializeGame() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\aarya\\OneDrive\\Desktop\\STICK-HERO\\Stick-Hero-Game\\stickhero3\\src\\main\\resources\\com\\example\\stickhero3\\gameState.ser" ))) {
            oos.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserializeSavedGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\aarya\\OneDrive\\Desktop\\STICK-HERO\\Stick-Hero-Game\\stickhero3\\src\\main\\resources\\com\\example\\stickhero3\\savedGameState.ser" ))) {
            game = (Game) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void savedGame(ActionEvent event) throws IOException {
        deserializeSavedGame();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml" ));
        Parent root = loader.load();

        Scene1Controller scene1Controller = loader.getController();
        scene1Controller.setup();

        scene1Controller.setScore(game.getPlayerScore());
        scene1Controller.setRewards(game.getPlayerRewards());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void help(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene4.fxml" ));
        this.event = event;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml" ));
        this.event = event;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pauseScreen(ActionEvent event) throws IOException {
        serializeGame();
        FXMLLoader parent = new FXMLLoader(getClass().getResource("scene3.fxml" ));
        Parent root = parent.load();
        Scene3Controller scene3Controller = parent.getController();
        scene3Controller.setTotalScore(totalScore);

        this.event = event;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeAvatarCrash() {
        boolean ifFalling = false;

        double avatarPosition = pillar1.getLayoutX() + pillar1.getWidth() + stick.getHeight() - 10;


        if (avatarPosition < pillar2.getLayoutX() || avatarPosition > (pillar2.getLayoutX() + pillar2.getWidth())) {
            ifFalling = true;
        }
        Timeline timelineCrashAvatar = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(avatar.layoutYProperty(), avatar.getLayoutY())),
                new KeyFrame(Duration.millis(500), new KeyValue(avatar.layoutYProperty(), 600))
        );
        if (ifFalling) {
            Music bgm = new Music("C:\\Users\\aarya\\OneDrive\\Desktop\\STICK-HERO\\Stick-Hero-Game\\stickhero3\\src\\main\\java\\com\\example\\stickhero3\\bgmusic.wav");
            bgm.start();
            timelineCrashAvatar.play();
            timelineCrashAvatar.setOnFinished(
                    actionEvent -> {
                        try {
                            displayGameOverScreen();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } else {
            checkMidpoint();
            totalScore++;
            setScore(totalScore);
            shiftPillars();
        }


    }

    public void checkMidpoint(){
        if (stick.getLayoutX() + stick.getHeight() >= midpoint.getLayoutX() && stick.getLayoutX() + stick.getHeight() <= midpoint.getLayoutX() + midpoint.getWidth()){
            totalScore++;
        }
    }

    public void invertAvatar(KeyEvent event) {
        if (event.getCode() == javafx.scene.input.KeyCode.SPACE){
            System.out.println("SPACE");
        }
    }

    private void moveAvatar() {

        double toMove = stick.getLayoutX() + stick.getHeight() - avatar.getFitWidth();

        Timeline timelineMoveAvatar = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(avatar.layoutXProperty(), avatar.getLayoutX())),
                new KeyFrame(Duration.millis(650), new KeyValue(avatar.layoutXProperty(), toMove))
        );
        timelineMoveAvatar.play();
        timelineMoveAvatar.setOnFinished(actionEvent -> {
            makeAvatarCrash();
        });
    }

    void shiftPillars() {
        Timeline timelineMovePillar = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(pillar2.layoutXProperty(), pillar2.getLayoutX())),
                new KeyFrame(Duration.millis(650), new KeyValue(pillar2.layoutXProperty(), 116 - pillar2.getWidth()))
        );

        Rotate rotate = new Rotate();
        rotate.setPivotX(stick.getY());
        rotate.setPivotY(stick.getX() + stick.getHeight());
        stick.getTransforms().add(rotate);
        rotate.setAngle(90);
        RotateTransition rotation = new RotateTransition(Duration.millis(50), stick);
        rotation.play();

        Timeline timelineMoveStick = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(stick.layoutXProperty(), stick.getLayoutX())),
                new KeyFrame(Duration.millis(650), new KeyValue(stick.layoutXProperty(), 107))
        );

        Timeline timelineMoveAvatar = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(avatar.layoutXProperty(), avatar.getLayoutX())),
                new KeyFrame(Duration.millis(650), new KeyValue(avatar.layoutXProperty(), 78))
        );

        timelineMoveStick.play();
        timelineMoveAvatar.play();
        timelineMovePillar.play();


        PauseTransition pause = new PauseTransition(Duration.millis(650));
        pause.setOnFinished(event -> {

            Rectangle newStick = new Rectangle();
            newStick.setHeight(30);
            newStick.setWidth(7);
            newStick.setLayoutY(291);
            newStick.setLayoutX(107);
            newStick.setFill(stick.getFill());
            anchorPane2.getChildren().add(newStick);
            anchorPane2.getChildren().remove(stick);
            stick = newStick;

            Random random1 = new Random();
            int min = 25;
            int max = 200;
            int randomWidth = random1.nextInt(max - min + 1) + min;

            Random random2 = new Random();
            int min1 = 50;
            int max1 = 250;
            int randomDistance = random2.nextInt(max1 - min1 + 1) + min1;

            Rectangle newPillar = new Rectangle();
            newPillar.setHeight(pillar1.getHeight());
            newPillar.setLayoutY(pillar1.getLayoutY());
            newPillar.setWidth(randomWidth);
            newPillar.setLayoutX(pillar1.getLayoutX() + pillar1.getWidth() + randomDistance);
            newPillar.setFill(pillar1.getFill());
            anchorPane2.getChildren().remove(pillar1);
            anchorPane2.getChildren().add(newPillar);
            pillar1 = pillar2;
            pillar2 = newPillar;

            Double midValue = pillar2.getLayoutX() + (pillar2.getWidth()/2);
            Rectangle newMidpoint = new Rectangle();
            newMidpoint.setLayoutY(328);
            newMidpoint.setWidth(7);
            newMidpoint.setHeight(12);
            newMidpoint.setLayoutX(midValue);
            newMidpoint.setFill(midpoint.getFill());
            anchorPane2.getChildren().add(newMidpoint);
            anchorPane2.getChildren().remove(midpoint);
            midpoint=newMidpoint;


        });
        pause.play();

    }
}


