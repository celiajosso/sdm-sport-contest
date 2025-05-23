package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class PointScore extends Event {
    private String team;

    public PointScore(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Point scored by " + team);
        return true;
    }
}
