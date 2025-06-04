package org.example.Events.Football;

import org.example.Events.Event;
import org.example.MatchManager.FootballMatchManager;
import org.example.MatchState;
import org.example.contestant.Team;

public class MatchEnd extends Event {
    private final FootballMatchManager manager;

    public MatchEnd(FootballMatchManager manager) {
        super(manager.getMatch());
        this.manager = manager;
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.FINISHED);
        backup();

        Team teamA = (Team) match.getContestantA();
        Team teamB = (Team) match.getContestantB();
        int scoreA = manager.getScoreA();
        int scoreB = manager.getScoreB();

        if (scoreA > scoreB) {
            match.logEvent("Match ended: Team " + teamA.getFullname() + " won the match!");
        } else if (scoreB > scoreA) {
            match.logEvent("Match ended: Team " + teamB.getFullname() + " won the match!");
        } else {
            match.logEvent("The match ended in a draw.");
        }
        return true;
    }
}
