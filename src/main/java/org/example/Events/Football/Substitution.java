package org.example.Events.Football;

import org.example.Events.Event;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.TeamMember;

public class Substitution extends Event {
    private final FootballMatchManager manager;
    private final TeamMember outPlayer;
    private final TeamMember inPlayer;

    public Substitution(FootballMatchManager manager, TeamMember outPlayer, TeamMember inPlayer) {
        super(manager.getMatch());
        this.manager = manager;
        this.outPlayer = outPlayer;
        this.inPlayer = inPlayer;
    }

    @Override
    public boolean execute() {
        match.logEvent("Substitution for " + manager.getTeam(outPlayer).getFullname() + ": " + outPlayer.getFullname()
                + " out, "
                + inPlayer.getFullname() + " in");
        return true;
    }
}
