package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchState;

public class MatchStart extends Event {
    public MatchStart(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.IN_PROGRESS);
        backup();

        match.logEvent("Volleyball match started");

        return true;
    }
}
