package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchState;

public class MatchStart extends Event {
    public MatchStart(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.IN_PROGRESS);
        backup();

        match.logEvent("Football Match Started: " + match.getTeamA().getTeamName() + " vs " + match.getTeamB().getTeamName());

        match.getTeamA().displayTeam();
        match.getTeamB().displayTeam();

        return true;
    }
}