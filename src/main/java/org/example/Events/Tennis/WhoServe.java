package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Player;

public class WhoServe extends Event {
    private final Player player;

    public WhoServe(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent(player.getFullname() + " to serve");
        return true;
    }
}
