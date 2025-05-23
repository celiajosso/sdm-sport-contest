package org.example;

public class MatchState {
    private int scoreA;
    private int scoreB;

    public MatchState(int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }    
}
