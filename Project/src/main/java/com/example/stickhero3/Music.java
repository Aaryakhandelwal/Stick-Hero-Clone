package com.example.stickhero3;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class Music extends Thread{
    Clip clip;
    File file;
    public Music(String path){
        this.file = new File(path);
    }

    public Clip getClip() {
        return clip;
    }

    public File getFile() {
        return file;
    }

    public void run() {
        AudioInputStream audio = null;
        try {
            audio = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clip.open(audio);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
