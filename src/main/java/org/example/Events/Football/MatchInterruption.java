package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class MatchInterruption extends Event {

    public MatchInterruption(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Match interrupted");
        return true;
    }
}
