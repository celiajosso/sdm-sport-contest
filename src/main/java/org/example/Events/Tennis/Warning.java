package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Player;

public class Warning extends Event {
    private final Player player;
    private final String reason;

    public Warning(Match match, Player player, String reason) {
        super(match);
        this.player = player;
        this.reason = reason;
    }

    @Override
    public boolean execute() {
        match.logEvent("Warning to " + player.getPseudonym() + ": " + reason);
        return true;
    }
}
