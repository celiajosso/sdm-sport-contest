package org.example.Events.Football;

import org.example.Events.Event;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.Team;
import org.example.Match;

public class GoalCancel extends Event {
    private Team team;
    private FootballMatchManager manager;

    public GoalCancel(Match match, FootballMatchManager manager, Team team) {
        super(match);
        this.manager = manager;
        this.team = team;
    }

    @Override
    public boolean execute() {
        backup();
        manager.decrementScore(team);
        match.logEvent("Goal cancelled for " + team.getTeamName());
        return true;
    }
}
