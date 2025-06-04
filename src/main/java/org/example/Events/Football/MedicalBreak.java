package org.example.Events.Football;

import org.example.Events.Event;
import org.example.contestant.TeamMember;
import org.example.Match;

public class MedicalBreak extends Event {
    private final TeamMember member;

    public MedicalBreak(Match match, TeamMember member) {
        super(match);
        this.member = member;
    }

    @Override
    public boolean execute() {
        match.logEvent("Medical break requested for " + member.getFullname());
        return true;
    }
}
