package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Match {
    private Integer matchId;
    private String team1;
    private String team2;
    private String dateTime;
    private String location;
    private int scoreA;
    private int scoreB;
    
    private Map<String, Integer> score = new HashMap<>();
    private List<String> eventLog = new ArrayList<>();

    public Match(Integer matchId, String team1, String team2, String dateTime, String location) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.dateTime = dateTime;
        this.location = location;
        this.scoreA = 0;
        this.scoreB = 0;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

   public MatchState getState() {
        return new MatchState(scoreA, scoreB);
    }

    public void setState(MatchState state) {
        this.scoreA = state.getScoreA();
        this.scoreB = state.getScoreB();
    }

    public void addScoreA(int points) {
        this.scoreA += points;
    }

    public void addScoreB(int points) {
        this.scoreB += points;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void incrementScore(String team) {
        score.put(team, score.getOrDefault(team, 0) + 1);
    }

    public void logEvent(String description) {
        eventLog.add(description);
    }

}
