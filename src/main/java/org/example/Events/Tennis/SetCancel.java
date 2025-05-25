package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;
import org.example.Match;

public class SetCancel extends Event {
    private int setNumber;
    private Player player;
    private TennisMatchManager manager;

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
