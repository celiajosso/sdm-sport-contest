package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.Team;
import org.example.Match;

public class Offside extends Event {
    private Team team;

    public Offside(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Offside by " + team.getTeamName());
        return true;
    }
}
