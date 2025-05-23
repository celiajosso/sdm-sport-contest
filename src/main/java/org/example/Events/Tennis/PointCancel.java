package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class PointCancel extends Event {
    private String player;

    public PointCancel(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Point cancelled for " + player);
        return true;
    }
}
