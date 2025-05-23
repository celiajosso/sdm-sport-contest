package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class MatchEnd extends Event {
    public MatchEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Volleyball match ended");
        return true;
    }
}
