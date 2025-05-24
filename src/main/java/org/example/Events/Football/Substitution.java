package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;
import org.example.Match;

public class Substitution extends Event {
    private Team team;
    private TeamMember outPlayer;
    private TeamMember inPlayer;

    public Substitution(Match match, Team team, TeamMember outPlayer, TeamMember inPlayer) {
        super(match);
        this.team = team;
        this.outPlayer = outPlayer;
        this.inPlayer = inPlayer;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution for " + team.getTeamName() + ": " + outPlayer.getPseudonym() + " out, " + inPlayer.getPseudonym() + " in");
        return true;
    }
}
