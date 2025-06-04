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

    public String getScoreDisplay() {
        return getMatch().getContestantA().getFullname() + " " + scoreA + " - " +
                scoreB + " " + getMatch().getContestantB().getFullname();
    }

    public void incrementScore(Team team) {
        // if (team == null) {
        // throw new IllegalArgumentException("Team cannot be null");
        // }
        if (getMatch().getContestantA().equals(team)) {
            scoreA++;

        } else if (getMatch().getContestantB().equals(team)) {
            scoreB++;
        }

    }

    public void decrementScore(Team team) {
        if (team.equals(getMatch().getContestantA()) && scoreA > 0) {
            scoreA--;
        } else if (team.equals(getMatch().getContestantB()) && scoreB > 0) {
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
        if (scoreA > scoreB) {
            return match.getContestantA();
        } else if (scoreB > scoreA) {
            return match.getContestantB();
        } else {
            return null;
        }
    }

    public Team getTeam(org.example.contestant.TeamMember member) {
        if (getMatch().getContestantA() instanceof Team teamA) {
            for (org.example.contestant.TeamMember m : teamA.getTeamMembers()) {
                if (m.equals(member)) {
                    return teamA;
                }
            }
        }
        if (getMatch().getContestantB() instanceof Team teamB) {
            for (org.example.contestant.TeamMember m : teamB.getTeamMembers()) {
                if (m.equals(member)) {
                    return teamB;
                }
            }
        }
        return null;
    }

}
