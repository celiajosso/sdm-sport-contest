package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchState;

public class MatchInterruption extends Event {

    public MatchInterruption(Match match) {
        super(match);
    }

    @Override
    public boolean execute() {
        match.setState(MatchState.INTERRUPTED);
        backup();

        match.logEvent("Match interrupted");
        return true;
    }
}
