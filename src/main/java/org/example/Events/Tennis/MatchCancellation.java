package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class MatchCancellation extends Event {
    public MatchCancellation(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tennis match cancelled");
        return true;
    }
}
