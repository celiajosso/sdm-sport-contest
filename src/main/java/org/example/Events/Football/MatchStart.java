package org.example.Events.Football;

import org.example.Match;
import org.example.Events.Event;

public class MatchStart extends Event {
    public MatchStart(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Football Match Started");
        return true;
    }
}