package com.example.stickhero3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class GameController {
    @FXML
    private Rectangle stick;
    private AnchorPane anchorPane;
    @FXML
    public void extendStick(ActionEvent e){
        System.out.println("Hello");
        anchorPane.setOnKeyPressed(event -> {
            if (event.getCode()== KeyCode.SPACE){
                stick.setHeight(stick.getHeight()+10);
            }
        });
        anchorPane.requestFocus();
    }
}
