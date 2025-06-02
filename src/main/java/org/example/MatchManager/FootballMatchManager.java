package org.example.MatchManager;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;

public class FootballMatchManager extends MatchManager {
    private int scoreA = 0;
    private int scoreB = 0;

    public FootballMatchManager(Match match) {
        super(match);
    }

    public int getScoreTeamA() {
        return scoreA;
    }

    public int getScoreTeamB() {
        return scoreB;
    }

    public String getScoreDisplay() {
        return getMatch().getTeamA().getTeamName() + " " + scoreA + " - " +
                scoreB + " " + getMatch().getTeamB().getTeamName();
    }

    public void incrementScore(Team team) {
        if (team.equals(getMatch().getTeamA())) {
            scoreA++;
        } else if (team.equals(getMatch().getTeamB())) {
            scoreB++;
        }
    }

    public void decrementScore(Team team) {
        if (team.equals(getMatch().getTeamA()) && scoreA > 0) {
            scoreA--;
        } else if (team.equals(getMatch().getTeamB()) && scoreB > 0) {
            scoreB--;
        }
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void applyFootballEvent(Event event) {
        applyEvent(event);
    }

}
