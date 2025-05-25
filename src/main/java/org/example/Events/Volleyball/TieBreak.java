package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class TieBreak extends Event {
    public TieBreak(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Tiebreak started in volleyball match");
        return true;
    }
}
