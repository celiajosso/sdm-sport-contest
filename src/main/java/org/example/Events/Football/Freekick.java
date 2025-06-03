package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;

public class Freekick extends Event {
    private final Team team;

    public Freekick(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Freekick for team " + team.getFullname());
        return true;
    }
}
