package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Player;

public class Challenge extends Event {
    private final Player player;

    public Challenge(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Challenge by " + player.getFullname());
        return true;
    }
}
