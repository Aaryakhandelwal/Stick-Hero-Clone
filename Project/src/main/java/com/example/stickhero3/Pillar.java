package com.example.stickhero3;

import javafx.scene.shape.Rectangle;

public class Pillar implements InitSetup{
    private Rectangle shapeParameters;

    public Pillar(Rectangle shapeParameters) {
        this.shapeParameters = shapeParameters;
    }

    public Rectangle getShapeParameters() {
        return shapeParameters;
    }
    @Override
    public void setup(){
        if(this.shapeParameters == null){
            System.out.println("Null values detected");
        }
    }
    public void setShapeParameters(Rectangle shapeParameters) {
        this.shapeParameters = shapeParameters;
    }
}
