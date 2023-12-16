package com.example.stickhero3;

import javafx.scene.image.ImageView;

public class Avatar implements InitSetup {
    private String name;
    private ImageView avatar;
    private boolean ifInverted;
    private boolean ifFall;
    private static Avatar Avatar = null;

    private  Avatar( ImageView avatar) {
        this.avatar = avatar;
    }

    public static Avatar getInstance(ImageView avatar){
        if (avatar==null){
            Avatar = new Avatar(avatar);
        }
        return Avatar;

    }

    @Override
    public void setup(){
        if(this.avatar == null){
            System.out.println("Null values detected");
        }
        else{
            setIfInverted(false);
            setAvatar(avatar);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public boolean isIfInverted() {
        return ifInverted;
    }

    public void setIfInverted(boolean ifInverted) {
        this.ifInverted = ifInverted;
    }

    public boolean isIfFall() {
        return ifFall;
    }

    public void setIfFall(boolean ifFall) {
        this.ifFall = ifFall;
    }
}
