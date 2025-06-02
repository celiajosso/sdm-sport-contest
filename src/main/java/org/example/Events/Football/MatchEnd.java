package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.FootballMatchManager;
import org.example.MatchState;
import org.example.contestant.Team;

public class MatchEnd extends Event {
    private final FootballMatchManager manager;

    public MatchEnd(Match match, FootballMatchManager manager) {
        super(match);
        this.manager = manager;
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.FINISHED);
        backup();

        Team teamA = (Team) match.getTeamA();
        Team teamB = (Team) match.getTeamB();
        int scoreA = manager.getScoreA();
        int scoreB = manager.getScoreB();

        match.logEvent("Match ended");

        if (scoreA > scoreB) {
            match.logEvent("Team " + teamA.getTeamName() + " won the match!");
        } else if (scoreB > scoreA) {
            match.logEvent("Team " + teamB.getTeamName() + " won the match!");
        } else {
            match.logEvent("The match ended in a draw.");
        }
        return true;
    }
}
