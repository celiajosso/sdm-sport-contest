package org.example;

import org.example.MatchManager.FootballMatchManager;
import org.example.MatchManager.MatchManager;
import org.example.MatchManager.TennisMatchManager;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Match {
    public final Sport sport;
    private final Integer matchId;
    private Contestant contestantA;
    private Contestant contestantB;
    private final String dateTime;
    private final String location;
    private final List<String> eventLog = new ArrayList<>();
    private final MatchManager matchManager;
    private MatchState matchState = MatchState.NOT_STARTED;

    public Match(Integer matchId, Sport sport, Contestant contestantA, Contestant contestantB, String dateTime,
            String location) {
        this.matchId = matchId;
        this.contestantA = contestantA;
        this.contestantB = contestantB;
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

    public Contestant getContestantA() {
        return contestantA;
    }

    public Contestant getContestantB() {
        return contestantB;
    }

    public void setContestantA(Contestant a) {
        this.contestantA = a;
    }

    public void setContestantB(Contestant b) {
        this.contestantB = b;
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss   ");
        String message = "   " + now.format(formatter) + description;
        eventLog.add(message);
        System.out.println(message);
    }

    public List<String> getEventLog() {
        return eventLog;
    }
}
