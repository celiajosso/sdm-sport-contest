package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class MatchEnd extends Event {
    public MatchEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tennis match ended");
        return true;
    }
}
