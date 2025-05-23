package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class GameEnd extends Event {
    public GameEnd(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tennis game ended");
        return true;
    }
}
