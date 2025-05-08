package org.example.Events;

public abstract class Event {

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
