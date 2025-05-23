package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class Challenge extends Event {
    private String player;

    public Challenge(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Challenge by " + player);
        return true;
    }
}
