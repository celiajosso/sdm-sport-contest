package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;

public class PointCancel extends Event {
    private final Player player;

    public PointCancel(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Point cancelled for " + player.getFullname());
        TennisMatchManager manager = new TennisMatchManager(match);
        manager.cancelLastPoint(player);
        return true;
    }
}
