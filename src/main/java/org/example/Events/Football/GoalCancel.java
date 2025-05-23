package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class GoalCancel extends Event {
    private String team;

    public GoalCancel(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Goal cancelled for " + team);
        return true;
    }
}
