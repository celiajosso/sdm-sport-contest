package org.example.MatchManager;

import org.example.Match;
import org.example.Events.Event;

public abstract class MatchManager {
    protected Match match;
    protected MatchEventHistory eventHistory;

    public MatchManager(Match match) {
        this.match = match;
        this.eventHistory = new MatchEventHistory();
    }

    public void applyEvent(Event event) {
        if (event.execute()) {
            eventHistory.addEvent(event);
            eventHistory.notifySubscribers(event);
        }
    }

    public MatchEventHistory getEventHistory() {
        return eventHistory;
    }
}
