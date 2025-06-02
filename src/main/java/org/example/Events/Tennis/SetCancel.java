package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;

public class SetCancel extends Event {
    private final int setNumber;
    private final Player player;
    private final TennisMatchManager manager;

    public SetCancel(Match match, int setNumber, Player player, TennisMatchManager manager) {
        super(match);
        this.setNumber = setNumber;
        this.player = player;
        this.manager = manager;
    }

    @Override
    public boolean execute() {
        backup();
        manager.cancelLastSet(player);

        match.logEvent("Set " + setNumber + " cancelled for player " + player.getPseudonym());
        return true;
    }
}
