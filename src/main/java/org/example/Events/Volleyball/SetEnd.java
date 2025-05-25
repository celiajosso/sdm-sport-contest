package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Team;
import org.example.Match;

public class SetEnd extends Event {
    private int setNumber;
    private Team scoringTeam;
    private VolleyballMatchManager manager;

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

        match.logEvent("Set " + setNumber + " ended" + scoringTeam.getTeamName() + " won the set.");
        return true;
    }
}
