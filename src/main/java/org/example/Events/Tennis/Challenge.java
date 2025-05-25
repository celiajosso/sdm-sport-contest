package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.contestant.Player;
import org.example.Match;

public class Challenge extends Event {
    private Player player;

    public Challenge(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Challenge by " + player.getPseudonym());
        return true;
    }
}
