package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;

public class SetCancel extends Event {
    private final int setNumber;
    private final Player player;
    private final TennisMatchManager manager;

    public SetCancel(TennisMatchManager manager, int setNumber, Player player) {
        super(manager.getMatch());
        this.setNumber = setNumber;
        this.player = player;
        this.manager = manager;
    }

    @Override
    public boolean execute() {
        backup();
        manager.cancelLastSet(player);

        match.logEvent("Set " + setNumber + " cancelled for player " + player.getFullname());
        return true;
    }
}
