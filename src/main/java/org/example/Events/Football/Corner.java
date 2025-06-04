package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;

public class Corner extends Event {
    private final Team team;

    public Corner(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Corner for team " + team.getFullname() + ")");
        return true;
    }
}