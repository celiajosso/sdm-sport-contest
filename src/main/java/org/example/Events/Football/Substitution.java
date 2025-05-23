package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;

public class Substitution extends Event {
    private String team;
    private String outPlayer;
    private String inPlayer;

    public Substitution(Match match, String team, String outPlayer, String inPlayer) {
        super(match);
        this.team = team;
        this.outPlayer = outPlayer;
        this.inPlayer = inPlayer;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution for " + team + ": " + outPlayer + " out, " + inPlayer + " in");
        return true;
    }
}
