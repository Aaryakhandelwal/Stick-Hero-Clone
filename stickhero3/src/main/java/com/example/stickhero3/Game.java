package com.example.stickhero3;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private int playerScore;
    private int playerRewards;

    public int getPlayerScore() {
        return playerScore;
    }

    public Game(int playerScore, int playerRewards) {
        this.playerScore = playerScore;
        this.playerRewards = playerRewards;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerRewards() {
        return playerRewards;
    }

    public void setPlayerRewards(int playerRewards) {
        this.playerRewards = playerRewards;
    }
}
