package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class Freekick extends Event {
    private String team;

    public Freekick(Match match, String team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        match.logEvent("Freekick for " + team);
        return true;
    }
}
