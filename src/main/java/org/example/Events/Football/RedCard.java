package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.TeamMember;

public class RedCard extends Event {
    private final TeamMember player;

    public RedCard(Match match, TeamMember player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        backup();
        player.giveRedCard();
        match.logEvent("Red card for " + player.getFullname());
        return true;
    }
}
