package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class SetStart extends Event {
    private int setNumber;

    public SetStart(Match match, int setNumber) {
        super(match);
        this.setNumber = setNumber;
    }

    @Override
    public boolean execute() {
        match.logEvent("Set " + setNumber + " started");
        return true;
    }
}
