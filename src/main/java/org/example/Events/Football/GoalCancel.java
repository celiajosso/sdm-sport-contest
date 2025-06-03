package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.Team;

public class GoalCancel extends Event {
    private final Team team;
    private final FootballMatchManager manager;

    public GoalCancel(Match match, FootballMatchManager manager, Team team) {
        super(match);
        this.manager = manager;
        this.team = team;
    }

    @Override
    public boolean execute() {
        backup();
        manager.decrementScore(team);
        match.logEvent("Goal cancelled for " + team.getFullname() + "-> Actual score: " + manager.getScoreA() + "-"
                + manager.getScoreB());
        return true;
    }
}
