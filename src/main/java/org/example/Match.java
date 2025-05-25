package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.MatchManager.FootballMatchManager;
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

    private TennisMatchManager tennisMatchManager = new TennisMatchManager(this);
    private FootballMatchManager footballMatchManager = new FootballMatchManager(this);
    private VolleyballMatchManager volleyballMatchManager = new VolleyballMatchManager(this);

    public Match(Integer matchId, Team teamA, Team teamB, String dateTime, String location) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateTime = dateTime;
        this.location = location;
    }

    public TennisMatchManager getTennisMatchManager() {
        return tennisMatchManager;
    }

    public FootballMatchManager getFootballMatchManager() {
        return footballMatchManager;
    }

    public VolleyballMatchManager getVolleyBallMatchManager() {
        return volleyballMatchManager;
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
