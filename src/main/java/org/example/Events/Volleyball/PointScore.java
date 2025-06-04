package org.example.Events.Volleyball;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Team;

public class PointScore extends Event {
    private final Team team;

    public PointScore(Match match, Team team) {
        super(match);
        this.team = team;
    }

    @Override
    public boolean execute() {
        VolleyballMatchManager manager = new VolleyballMatchManager(match);
        manager.pointScored(team);

        // match.logEvent("Point scored by " + team.getFullname());
        return true;
    }
}
