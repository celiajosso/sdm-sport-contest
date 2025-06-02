package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Player;
import org.example.contestant.Team;

public class Substitution extends Event {
    private final Player playerOut;
    private final Player playerIn;
    private final Team team;

    public Substitution(Match match, Team team, Player playerOut, Player playerIn) {
        super(match);
        this.team = team;
        this.playerOut = playerOut;
        this.playerIn = playerIn;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution in " + team.getFullname() + ": " + playerOut.getFullname() + " out, " + playerIn.getFullname() + " in");
        return true;
    }
}
