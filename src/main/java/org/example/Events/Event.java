package org.example.Events;

import org.example.Match;
import org.example.MatchState;

public abstract class Event implements Command {

    protected Match match;
    private MatchState backup;

    public Event(Match match) {
        this.match = match;
    }

    protected void backup() {
        this.backup = match.getState();
    }

    public abstract boolean execute();
}
