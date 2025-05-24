package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class HalfTime extends Event {

    public HalfTime(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Halftime reached");
        return true;
    }
}
