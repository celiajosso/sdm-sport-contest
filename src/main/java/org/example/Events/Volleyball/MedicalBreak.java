package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class MedicalBreak extends Event {
    public MedicalBreak(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.logEvent("Medical break in volleyball match");
        return true;
    }
}
