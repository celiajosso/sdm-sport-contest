package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

public class YellowCard extends Event {
    private final TeamMember player;
    private final Team team;

    public YellowCard(Match match, TeamMember player, Team team) {
        super(match);
        this.player = player;
        this.team = team;
    }

    @Override
    public boolean execute() {
        backup();
        player.giveYellowCard();
        match.logEvent("Yellow card for " + player.getFullname());
        if (player.getYellowCards() >= 2) {
            player.giveRedCard();
            match.logEvent(
                    "Red card for " + player.getFullname() + " due to second yellow (team " + team.getFullname() + ")");
        }
        return true;
    }
}
