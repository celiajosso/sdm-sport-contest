package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class WhoServe extends Event {
    private String player;

    public WhoServe(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent(player + " to serve in volleyball match");
        return true;
    }
}
