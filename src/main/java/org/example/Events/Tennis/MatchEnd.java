package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchState;
import org.example.contestant.Player;

public class MatchEnd extends Event {
    public MatchEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.FINISHED);
        backup();

        Player playerA = (Player) match.getTeamA().getTeamMembers()[0];
        Player playerB = (Player) match.getTeamB().getTeamMembers()[0];

        int setsWonByA = match.getTennisMatchManager().getSetsWon(playerA);
        int setsWonByB = match.getTennisMatchManager().getSetsWon(playerB);

        match.logEvent("Tennis match ended");

        if (setsWonByA > setsWonByB) {
            match.logEvent("Player " + playerA.getFullname() + " won the match!");
        } else if (setsWonByB > setsWonByA) {
            match.logEvent("Player " + playerB.getFullname() + " won the match!");
        } else {
            match.logEvent("The match ended in a draw (impossible in tennis).");
        }
        return true;
    }
}
