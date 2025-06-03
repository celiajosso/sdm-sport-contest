package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

public class RedCard extends Event {
    private final TeamMember player;
    private final Team team;

    public RedCard(Match match, TeamMember player, Team team) {
        super(match);
        this.player = player;
        this.team = team;
    }

    @Override
    public boolean execute() {
        backup();
        player.giveRedCard();
        match.logEvent("Red card for " + player.getFullname() + " (team " + team.getFullname() + ")");
        return true;
    }
}
