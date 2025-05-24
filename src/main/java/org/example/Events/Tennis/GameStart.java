package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class GameStart extends Event {
    public GameStart(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tennis game started");
        return true;
    }
}
