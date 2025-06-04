package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.contestant.Player;
import org.example.Match;

public class MedicalBreak extends Event {
    private final Player player;

    public MedicalBreak(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Medical break in tennis match requested for " + player.getFullname());
        return true;
    }
}
