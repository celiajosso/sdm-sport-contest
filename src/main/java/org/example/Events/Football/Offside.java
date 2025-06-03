package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

public class Offside extends Event {
    private final Team team;
    private final TeamMember member;

    public Offside(Match match, Team team, TeamMember member) {
        super(match);
        this.team = team;
        this.member = member;
    }

    @Override
    public boolean execute() {
        match.logEvent("Offside by " + member.getFullname() + " (team " + team.getFullname() + ")");
        return true;
    }
}
