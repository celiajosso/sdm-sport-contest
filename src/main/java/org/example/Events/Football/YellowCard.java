package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.TeamMember;
import org.example.Match;

public class YellowCard extends Event {
    private TeamMember player;

    public YellowCard(Match match, TeamMember player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        backup();
        player.giveYellowCard();
        match.logEvent("Yellow card for " + player.getPseudonym());
        if (player.getYellowCards() >= 2) {
            player.giveRedCard();
            match.logEvent("Red card for " + player.getPseudonym() + " due to second yellow.");
        }
        return true;
    }
}
