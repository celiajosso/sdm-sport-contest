package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.contestant.Player;
import org.example.Match;

public class Forfeit extends Event {
    private Player player;

    public Forfeit(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent(player.getPseudonym() + " forfeits the match");
        return true;
    }
}
