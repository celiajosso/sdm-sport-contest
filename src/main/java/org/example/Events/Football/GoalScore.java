package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

public class GoalScore extends Event {
    private final Team scoringTeam;
    private final FootballMatchManager manager;
    private final TeamMember member;

    public GoalScore(Match match, FootballMatchManager manager, Team scoringTeam, TeamMember member) {
        super(match);
        this.manager = manager;
        this.scoringTeam = scoringTeam;
        this.member = member;
    }

    @Override
    public boolean execute() {
        backup();
        manager.incrementScore(scoringTeam);
        match.logEvent("Goal scored by " + member.getFullname() + " (team " + scoringTeam.getFullname()
                + ") -> Actual score: " + manager.getScoreA() + "-" + manager.getScoreB());
        return true;
    }
}
