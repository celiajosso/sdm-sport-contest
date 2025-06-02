package org.example.composite;

import org.example.Match;
import org.example.MatchState;
import org.example.contestant.Contestant;

public class MatchLeaf {
    private Match match;

    public Contestant execute() {
        if (match != null) {
            if (match.getState() == MatchState.FINISHED) {
                // return match.getWinner();
                return null;
            } else {
                return null;
            }
        } else {
            throw new IllegalStateException("Match is not set");
        }
    }

    public MatchLeaf(Match match) {
        this.match = match;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
