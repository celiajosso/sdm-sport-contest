package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class Overtime extends Event {
    private final int minutes;

    public Overtime(Match match, int minutes) {
        super(match);
        this.minutes = minutes;
    }

    @Override
    public boolean execute() {
        match.logEvent("Overtime of " + minutes + " minutes");
        return true;
    }
}
