package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;
import org.example.Match;

public class PointScore extends Event {
    private Player player;

    public PointScore(Match match, Player player) {
        super(match);
        this.player = player;
    }

    @Override
    public boolean execute() {
        TennisMatchManager manager = new TennisMatchManager(match);
        manager.pointScored(player);
        match.logEvent("Point scored by " + player.getPseudonym());
        return true;
    }
}
