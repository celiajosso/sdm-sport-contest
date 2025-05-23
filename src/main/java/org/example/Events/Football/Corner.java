package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class Corner extends Event {
    private String team;

    public Corner(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Corner for " + team);
        return true;
    }
}