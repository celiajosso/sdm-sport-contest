package org.example.Events;

import org.example.Match;

public abstract class Event implements Command {

    private Match match;

    private Matchstate backup;

    Event(Match match) {
        this.match = match;
    }

    void backup() {
        backup = match.getState();
    }

    public void undo() {
        match.setState(backup);
    }

    public abstract boolean execute();

}
