package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.contestant.Player;
import org.example.Match;

public class WhoServe extends Event {
    private Player player;

    public WhoServe(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent(player.getPseudonym() + " to serve in volleyball match");
        return true;
    }
}
