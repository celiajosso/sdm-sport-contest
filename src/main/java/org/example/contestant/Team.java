package org.example.contestant;

public class Team extends Contestant {
    private TeamMember[] teamMembers;
    private String teamName;
    private TeamMember teamLeader;

    public Team(String teamName, TeamMember teamLeader, TeamMember[] teamMembers) {
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public TeamMember getTeamLeader() {
        return teamLeader;
    }

    public TeamMember[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamLeader(TeamMember teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void setTeamMembers(TeamMember[] teamMembers) {
        this.teamMembers = teamMembers;
    }
}
