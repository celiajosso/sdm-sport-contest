package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class GoalScore extends Event {
    private String team;

    public GoalScore(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Goal scored by " + team);
        return true;
    }
}
