package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class Challenge extends Event {
    private String team;

    public Challenge(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Challenge requested by " + team);
        return true;
    }
}
