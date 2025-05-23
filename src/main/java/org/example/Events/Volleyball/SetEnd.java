package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class SetEnd extends Event {
    private int setNumber;

    public SetEnd(Match match, int setNumber) {
        super(match);
        this.setNumber = setNumber;
    }

    @Override
    public boolean execute() {
        match.logEvent("Set " + setNumber + " ended in volleyball match");
        return true;
    }
}
