package com.example.stickhero3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

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
