package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class SetCancel extends Event {
    private int setNumber;

    public SetCancel(Match match, int setNumber) {
        super(match);
        this.setNumber = setNumber;
    }

    @Override
    public boolean execute() {
        match.logEvent("Set " + setNumber + " cancelled");
        return true;
    }
}
