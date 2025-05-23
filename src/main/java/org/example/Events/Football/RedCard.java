package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class RedCard extends Event {
    private String player;

    public RedCard(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Red card for " + player);
        return true;
    }
}
