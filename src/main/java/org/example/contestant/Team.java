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
        return this.teamName;
    }

    public TeamMember getTeamLeader() {
        return this.teamLeader;
    }

    public TeamMember[] getTeamMembers() {
        return this.teamMembers;
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

    public void displayTeam() {
        System.out.println("Team Leader: " + teamLeader.getPseudonym());
        System.out.println("Team Members:");
        for (TeamMember member : this.getTeamMembers()) {
            System.out.println("- " + member.getPseudonym() + " (" + member.getRole() + ")");
        }
    }
}
