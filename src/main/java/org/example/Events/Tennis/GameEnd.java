package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;

public class GameEnd extends Event {
    private final Player scoringPlayer;
    private final TennisMatchManager manager;

    public GameEnd(TennisMatchManager manager, Player scoringPlayer) {
        super(manager.getMatch());
        this.manager = manager;
        this.scoringPlayer = scoringPlayer;
    }

    @Override
    public boolean execute() {
        backup();
        manager.winGame(scoringPlayer);
        match.logEvent("Tennis game ended, player " + scoringPlayer.getFullname() + " won the game.");
        return true;
    }
}
