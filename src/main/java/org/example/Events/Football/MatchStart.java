package org.example.Events.Football;

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

        match.logEvent("Football Match Started: " + ((Team) match.getTeamA()).getTeamName() + " vs " + ((Team) match.getTeamB()).getTeamName());

        ((Team) match.getTeamA()).displayTeam();
        ((Team) match.getTeamB()).displayTeam();

        return true;
    }
}