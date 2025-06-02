package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

public class Substitution extends Event {
    private final Team team;
    private final TeamMember outPlayer;
    private final TeamMember inPlayer;

    public Substitution(Match match, Team team, TeamMember outPlayer, TeamMember inPlayer) {
        super(match);
        this.team = team;
        this.outPlayer = outPlayer;
        this.inPlayer = inPlayer;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution for " + team.getFullname() + ": " + outPlayer.getFullname() + " out, " + inPlayer.getFullname() + " in");
        return true;
    }
}
