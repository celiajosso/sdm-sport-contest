package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;
import org.example.Match;

public class MedicalBreak extends Event {
    private final Team team;
    private final TeamMember member;

    public MedicalBreak(Match match, Team team, TeamMember member) {
        super(match);
        this.team = team;
        this.member = member;
    }

    @Override
    public boolean execute() {
        match.logEvent("Medical break requested for " + member.getFullname() + " (team " + team.getFullname() + ")");
        return true;
    }
}
