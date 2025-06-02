package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;

public class TieBreak extends Event {
    private final int setNumber;

    public TieBreak(Match match, int setNumber) {
        super(match);
        this.setNumber = setNumber;
    }

    @Override
    public boolean execute() {
        match.logEvent("Tiebreak in set " + setNumber);
        return true;
    }
}
