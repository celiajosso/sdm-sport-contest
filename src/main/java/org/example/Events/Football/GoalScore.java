package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.Team;

public class GoalScore extends Event {
    private final Team scoringTeam;
    private final FootballMatchManager manager;

    public GoalScore(Match match, FootballMatchManager manager, Team scoringTeam) {
        super(match);
        this.manager = manager;
        this.scoringTeam = scoringTeam;
    }

    @Override
    public boolean execute() {
        backup();
        manager.incrementScore(scoringTeam);
        match.logEvent("Goal scored by " + scoringTeam.getTeamName());
        return true;
    }
}
