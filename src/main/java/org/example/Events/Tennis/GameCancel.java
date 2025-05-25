package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;
import org.example.Match;

public class GameCancel extends Event {
    private Player scoringPlayer;
    private TennisMatchManager manager;

    public GameCancel(Match match, TennisMatchManager manager, Player scoringPlayer) {
        super(match);
        this.manager = manager;
        this.scoringPlayer = scoringPlayer;
    }

    @Override
    public boolean execute() {
        backup();
        manager.cancelLastGame(scoringPlayer);
        match.logEvent("Tennis game cancelled");
        return true;
    }
}
