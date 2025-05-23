package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class Forfeit extends Event {
    private String player;

    public Forfeit(Match match, String player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent(player + " forfeits the match");
        return true;
    }
}
