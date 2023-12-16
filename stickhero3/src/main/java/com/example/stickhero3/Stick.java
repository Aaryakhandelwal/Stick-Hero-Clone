package com.example.stickhero3;

import javafx.scene.shape.Rectangle;

public class Stick implements InitSetup {
    private double height;
    private double width;
    Rectangle stick;

    private static Stick Stick = null;
    private Stick(Rectangle stick) {
        this.stick=stick;
        this.height = height;
        this.width = width;
    }

    public static Stick getInstance(Rectangle stick){
        if (Stick==null){
            Stick = new Stick(stick);
        }
        return Stick;
    }

    @Override
    public void setup() {
        if(this.stick == null){
            System.out.println("Null values detected");
        }
        else{
            height=30;
            width=7;
            setHeight(stick.getHeight());
            setHeight(stick.getHeight());
        }

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }



}
