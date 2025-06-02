package org.example.Events.Tennis;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchState;
import org.example.contestant.Team;

public class MatchStart extends Event {
    public MatchStart(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.IN_PROGRESS);
        backup();

        match.logEvent("Tennis match started");

        ((Team) match.getTeamA()).displayTeam();
        ((Team) match.getTeamB()).displayTeam();

        return true;
    }
}
