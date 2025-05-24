package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.contestant.Team;
import org.example.Match;

public class Challenge extends Event {
    private Team team;

    public Challenge(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Challenge requested by " + team.getTeamName());
        return true;
    }
}
