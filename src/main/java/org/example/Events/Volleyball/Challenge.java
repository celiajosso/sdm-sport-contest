package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;

public class Challenge extends Event {
    private final Team team;

    public Challenge(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Challenge requested by " + team.getFullname());
        return true;
    }
}
