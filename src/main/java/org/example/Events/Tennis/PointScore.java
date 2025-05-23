package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class PointScore extends Event {
    private String player;

    public PointScore(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Point scored by " + player);
        return true;
    }
}
