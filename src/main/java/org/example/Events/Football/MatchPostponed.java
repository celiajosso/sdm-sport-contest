package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class MatchPostponed extends Event {

    public MatchPostponed(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Match postponed");
        return true;
    }
}
