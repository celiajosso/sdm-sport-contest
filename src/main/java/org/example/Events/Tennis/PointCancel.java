package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;
import org.example.Match;

public class PointCancel extends Event {
    private Player player;

    public PointCancel(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        match.logEvent("Point cancelled for " + player.getPseudonym());
        TennisMatchManager manager = new TennisMatchManager(match);
        manager.cancelLastPoint(player);
        return true;
    }
}
