package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.TeamMember;
import org.example.Match;

public class RedCard extends Event {
    private TeamMember player;

    public RedCard(Match match, TeamMember player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        backup();
        player.giveRedCard();
        match.logEvent("Red card for " + player.getPseudonym());
        return true;
    }
}
