package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.contestant.Team;
import org.example.Match;

public class Forfeit extends Event {
    private Team team;

    public Forfeit(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent(team.getTeamName() + " forfeits the volleyball match");
        return true;
    }
}
