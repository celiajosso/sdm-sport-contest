package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;

public class Substitution extends Event {
    private String playerOut;
    private String playerIn;
    private String team;

    public Substitution(Match match, String team, String playerOut, String playerIn) {
        super(match);
        this.team = team;
        this.playerOut = playerOut;
        this.playerIn = playerIn;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution in " + team + ": " + playerOut + " out, " + playerIn + " in");
        return true;
    }
}
