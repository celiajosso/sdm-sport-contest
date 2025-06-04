package org.example.Events.Football;

import org.example.Events.Event;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.TeamMember;

public class GoalScore extends Event {
    private final FootballMatchManager manager;
    private final TeamMember member;

    public GoalScore(FootballMatchManager manager, TeamMember member) {
        super(manager.getMatch());
        this.manager = manager;
        this.member = member;
    }

    @Override
    public boolean execute() {
        backup();
        manager.incrementScore(manager.getTeam(member));
        match.logEvent("Goal scored by " + member.getFullname() + " (team " + manager.getTeam(member).getFullname()
                + ") -> Actual score: " + manager.getScoreA() + "-" + manager.getScoreB());
        return true;
    }
}
