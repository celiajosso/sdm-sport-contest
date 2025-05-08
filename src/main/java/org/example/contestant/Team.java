package org.example.contestant;

public class Team extends Contestant {
    private TeamMember[] teamMembers;
    private String teamName;
    private String teamLeader;

    public Team(String teamName, String teamLeader, TeamMember[] teamMembers) {
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public TeamMember[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void setTeamMembers(TeamMember[] teamMembers) {
        this.teamMembers = teamMembers;
    }
}
