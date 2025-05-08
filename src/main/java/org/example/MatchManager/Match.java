package org.example.MatchManager;

public class Match {
    private Integer matchId;
    private String team1;
    private String team2;
    private String dateTime;
    private String location;

    public Match(Integer matchId, String team1, String team2, String dateTime, String location) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.dateTime = dateTime;
        this.location = location;
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

}
