package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.TeamMember;

public class YellowCard extends Event {
    private final TeamMember player;

    public YellowCard(Match match, TeamMember player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        backup();
        player.giveYellowCard();
        match.logEvent("Yellow card for " + player.getFullname());
        if (player.getYellowCards() >= 2) {
            player.giveRedCard();
            match.logEvent(
                    "Red card for " + player.getFullname() + " due to second yellow");
        }
        return true;
    }
}
