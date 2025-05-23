package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class Warning extends Event {
    private String player;
    private String reason;

    public Warning(Match match, String player, String reason) {
        super(match);
        this.player = player;
        this.reason = reason;
    }

    @Override
    public boolean execute() {
        match.logEvent("Warning to " + player + ": " + reason);
        return true;
    }
}
