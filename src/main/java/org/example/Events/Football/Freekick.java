package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.Team;
import org.example.Match;

public class Freekick extends Event {
    private Team team;

    public Freekick(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Freekick for " + team.getTeamName());
        return true;
    }
}
