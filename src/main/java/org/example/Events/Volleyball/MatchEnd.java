package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.MatchState;
import org.example.contestant.Team;

public class MatchEnd extends Event {
    public MatchEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.FINISHED);
        backup();

        Team teamA = (Team) match.getTeamA();
        Team teamB = (Team) match.getTeamB();

        int setsWonByA = ((VolleyballMatchManager) match.getMatchManager()).getSetsWon(teamA);
        int setsWonByB = ((VolleyballMatchManager) match.getMatchManager()).getSetsWon(teamB);

        match.logEvent("Volleyball match ended");

        if (setsWonByA > setsWonByB) {
            match.logEvent("Team " + teamA.getFullname() + " won the match!");
        } else if (setsWonByB > setsWonByA) {
            match.logEvent("Team " + teamB.getFullname() + " won the match!");
        } else {
            match.logEvent("The match ended in a draw (impossible in Volleyball).");
        }
        return true;
    }
}
