package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class MatchStart extends Event {
    public MatchStart(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tennis match started");
        return true;
    }
}
