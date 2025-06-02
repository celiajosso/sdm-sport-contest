package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.MatchManager.FootballMatchManager;
import org.example.MatchManager.MatchManager;
import org.example.MatchManager.TennisMatchManager;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Team;

public class Match {
    private Integer matchId;
    private Team teamA;
    private Team teamB;
    private String dateTime;
    private String location;
    private MatchState matchState = MatchState.NOT_STARTED;
    private List<String> eventLog = new ArrayList<>();

    private MatchManager matchManager;

    public Match(Integer matchId, Sport sport, Team teamA, Team teamB, String dateTime, String location) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateTime = dateTime;
        this.location = location;

        switch (sport) {
            case FOOTBALL -> this.matchManager = new FootballMatchManager(this);
            case TENNIS -> this.matchManager = new TennisMatchManager(this);
            case VOLLEYBALL -> this.matchManager = new VolleyballMatchManager(this);
            default -> throw new IllegalStateException("Unexpected value: " + sport);
        }

    }

    public MatchManager getMatchManager() {
        return matchManager;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public MatchState getState() {
        return matchState;
    }

    public void setState(MatchState matchState) {
        this.matchState = matchState;
    }

    public void logEvent(String description) {
        eventLog.add(description);
        System.out.println(description);
    }

    public List<String> getEventLog() {
        return eventLog;
    }
}
