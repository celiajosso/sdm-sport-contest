package org.example.MatchManager;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Contestant;
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
        return ((Team) getMatch().getTeamA()).getFullname() + " " + scoreA + " - " +
                scoreB + " " + ((Team) getMatch().getTeamB()).getFullname();
    }

    public void incrementScore(Team team) {
        // if (team == null) {
        //     throw new IllegalArgumentException("Team cannot be null");
        // }
        if (getMatch().getTeamA().equals(team)) {
            scoreA++;
            System.out.println("****************** : " + scoreA + " VS " + scoreB);

        } else if (getMatch().getTeamB().equals(team)) {
            scoreB++;
            System.out.println("****************** : " + scoreA + " VS " + scoreB);

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


    @Override
    public Contestant getWinner() {
        // System.out.println("---------------------"+scoreA+" "+scoreB+"---------------------");
        if (scoreA > scoreB) {
            return match.getTeamA();
        } else if (scoreB > scoreA) {
            return match.getTeamB();
        } else {
            return null; // match nul
        }
    }



}
