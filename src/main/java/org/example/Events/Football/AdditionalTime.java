package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class AdditionalTime extends Event {
    private final int minutes;

    public AdditionalTime(Match match, int minutes) {
        super(match);
        this.minutes = minutes;
    }

    @Override
    public boolean execute() {
        match.logEvent("Additional time: " + minutes + " minutes");
        return true;
    }
}