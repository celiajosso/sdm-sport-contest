package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.contestant.Player;
import org.example.contestant.Team;
import org.example.Match;

public class Substitution extends Event {
    private Player playerOut;
    private Player playerIn;
    private Team team;

    public Substitution(Match match, Team team, Player playerOut, Player playerIn) {
        super(match);
        this.team = team;
        this.playerOut = playerOut;
        this.playerIn = playerIn;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution in " + team.getTeamName() + ": " + playerOut.getPseudonym() + " out, " + playerIn.getPseudonym() + " in");
        return true;
    }
}
