package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.TennisMatchManager;
import org.example.contestant.Player;

public class SetEnd extends Event {
    private final int setNumber;
    private final Player scoringPlayer;
    private final TennisMatchManager manager;

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

        match.logEvent("Set " + setNumber + " ended" + scoringPlayer.getFullname() + " won the set.");
        return true;
    }
}
