package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;

public class Forfeit extends Event {
    private final Team team;

    public Forfeit(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent(team.getFullname() + " forfeits the volleyball match");
        return true;
    }
}
