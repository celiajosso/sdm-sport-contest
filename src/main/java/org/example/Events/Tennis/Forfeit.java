package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Player;

public class Forfeit extends Event {
    private final Player player;

    public Forfeit(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent(player.getFullname() + " forfeits the match");
        return true;
    }
}
