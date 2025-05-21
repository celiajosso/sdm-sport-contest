package org.example.contestant;

public class TeamMember extends Player {
    private String role;

    public TeamMember(String firstname, String surname, String pseudonym, String birthdate, String role, String teamName) {
        super(firstname, surname, pseudonym, birthdate);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
