package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Team;

public class SetEnd extends Event {
    private final int setNumber;
    private final Team scoringTeam;
    private final VolleyballMatchManager manager;

    public SetEnd(Match match, int setNumber, Team scoringTeam, VolleyballMatchManager manager) {
        super(match);
        this.setNumber = setNumber;
        this.scoringTeam = scoringTeam;
        this.manager = manager;
    }

    @Override
    public boolean execute() {
        backup();
        manager.winSet(scoringTeam);

        match.logEvent("Set " + setNumber + " ended" + scoringTeam.getFullname() + " won the set.");
        return true;
    }
}
