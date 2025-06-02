package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.TennisMatchManager;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.MatchState;
import org.example.contestant.Contestant;
import org.example.contestant.Player;

public class MatchEnd extends Event {
    public MatchEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.FINISHED);
        backup();

        Contestant playerA = match.getTeamA();
        Contestant playerB = match.getTeamB();

        int setsWonByA = ((TennisMatchManager)match.getMatchManager()).getSetsWon(playerA);
        int setsWonByB = ((TennisMatchManager)match.getMatchManager()).getSetsWon(playerB);

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
