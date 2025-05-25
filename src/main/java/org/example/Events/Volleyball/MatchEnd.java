package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.contestant.Player;
import org.example.contestant.Team;
import org.example.Match;
import org.example.MatchState;

public class MatchEnd extends Event {
    public MatchEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.FINISHED);
        backup();
        
        Team teamA = match.getTeamA();
        Team teamB = match.getTeamB();
        
        int setsWonByA = match.getVolleyBallMatchManager().getSetsWon(teamA);
        int setsWonByB = match.getVolleyBallMatchManager().getSetsWon(teamB);

        match.logEvent("Volleyball match ended");

        if (setsWonByA > setsWonByB) {
            match.logEvent("Team " + teamA.getTeamName() + " won the match!");
        } else if (setsWonByB > setsWonByA) {
            match.logEvent("Team " + teamB.getTeamName() + " won the match!");
        } else {
            match.logEvent("The match ended in a draw (impossible in Volleyball).");
        }
        return true;
    }
}
