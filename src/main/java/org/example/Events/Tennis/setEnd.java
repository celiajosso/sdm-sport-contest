package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;
import org.example.Match;

public class SetEnd extends Event {
    private int setNumber;
    private Player scoringPlayer;
    private TennisMatchManager manager;

    public SetEnd(Match match, int setNumber, Player scoringPlayer, TennisMatchManager manager) {
        super(match);
        this.setNumber = setNumber;
        this.scoringPlayer = scoringPlayer;
        this.manager = manager;
    }

    @Override
    public boolean execute() {
        backup();
        manager.winSet(scoringPlayer);

        match.logEvent("Set " + setNumber + " ended" + scoringPlayer.getPseudonym() + " won the set.");
        return true;
    }
}
