package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class YellowCard extends Event {
    private String player;

    public YellowCard(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Yellow card for " + player);
        return true;
    }
}
