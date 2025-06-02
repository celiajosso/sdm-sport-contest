package org.example;

import org.example.MatchManager.FootballMatchManager;
import org.example.MatchManager.MatchManager;
import org.example.MatchManager.TennisMatchManager;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final Integer matchId;
    private final Contestant teamA;
    private final Contestant teamB;
    private final String dateTime;
    private final String location;
    public final Sport sport;
    private final List<String> eventLog = new ArrayList<>();
    private final MatchManager matchManager;
    private MatchState matchState = MatchState.NOT_STARTED;

    public Match(Integer matchId, Sport sport, Contestant teamA, Contestant teamB, String dateTime, String location) {
        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateTime = dateTime;
        this.location = location;
        this.sport = sport;

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

    public Contestant getTeamA() {
        return teamA;
    }

    public Contestant getTeamB() {
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
