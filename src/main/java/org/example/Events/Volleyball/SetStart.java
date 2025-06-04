package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class SetStart extends Event {
    private final int setNumber;

    public SetStart(Match match, int setNumber) {
        super(match);
        this.setNumber = setNumber;
    }

    @Override
    public boolean execute() {
        match.logEvent("Set " + setNumber + " started in volleyball match");
        return true;
    }
}
