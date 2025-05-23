package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class Forfeit extends Event {
    private String team;

    public Forfeit(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent(team + " forfeits the volleyball match");
        return true;
    }
}
