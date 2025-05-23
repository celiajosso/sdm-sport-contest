package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class MatchStop extends Event {
    public MatchStop(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Volleyball match temporarily stopped");
        return true;
    }
}
