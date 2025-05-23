package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class Offside extends Event {
    private String team;

    public Offside(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Offside by " + team);
        return true;
    }
}
