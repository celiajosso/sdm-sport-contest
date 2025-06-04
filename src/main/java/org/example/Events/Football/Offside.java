package org.example.Events.Football;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.TeamMember;

public class Offside extends Event {
    private final TeamMember member;

    public Offside(Match match, TeamMember member) {
        super(match);
        this.member = member;
    }

    @Override
    public boolean execute() {
        match.logEvent("Offside by " + member.getFullname());
        return true;
    }
}
