package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;

public class Penalty extends Event {
    private final Team team;

    public Penalty(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Penalty for " + team.getTeamName());
        return true;
    }
}
