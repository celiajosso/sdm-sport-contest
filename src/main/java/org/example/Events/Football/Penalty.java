package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class Penalty extends Event {
    private String team;

    public Penalty(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Penalty for " + team);
        return true;
    }
}
