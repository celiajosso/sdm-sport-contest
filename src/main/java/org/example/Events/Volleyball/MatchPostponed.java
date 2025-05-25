package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchState;

public class MatchPostponed extends Event {
    public MatchPostponed(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.POSTPONED);
        backup();

        match.logEvent("Volleyball match postponed");
        return true;
    }
}
