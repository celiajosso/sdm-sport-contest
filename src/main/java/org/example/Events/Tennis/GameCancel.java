package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class GameCancel extends Event {
    public GameCancel(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tennis game cancelled");
        return true;
    }
}
