package org.example.contestant;

import java.util.Objects;

public class Team extends Contestant {
    private final TeamMember[] teamMembers;
    private final String teamName;
    private final TeamMember teamLeader;

    public Team(String teamName, TeamMember teamLeader, TeamMember[] teamMembers) {
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.teamMembers = teamMembers;
    }

    @Override
    public String getFullname() {
        return this.teamName;
    }

    public TeamMember getTeamLeader() {
        return this.teamLeader;
    }

    public TeamMember[] getTeamMembers() {
        return this.teamMembers;
    }

    public void displayTeam() {
        System.out.println("\nTeam name: " + teamName);
        System.out.println("Team Leader: " + teamLeader.getFullname());
        System.out.println("Team Members:");
        for (TeamMember member : this.getTeamMembers()) {
            System.out.println("- " + member.getFullname() + " (" + member.getRole() + ")");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Team other = (Team) obj;
        return Objects.equals(teamName, other.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
