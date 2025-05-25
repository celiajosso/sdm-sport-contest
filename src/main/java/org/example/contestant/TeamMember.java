package org.example.contestant;

public class TeamMember extends Player {
    private String role;
    private int yellowCards = 0;
    private boolean redCard = false;

    public TeamMember(String firstname, String surname, String pseudonym, String birthdate, String role, String teamName) {
        super(firstname, surname, pseudonym, birthdate);
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void giveYellowCard() {
        yellowCards++;
        if (yellowCards >= 2) {
            this.redCard = true;
        }
    }

    public void giveRedCard() {
        this.redCard = true;
    }

    public int getYellowCards() {
        return this.yellowCards;
    }
    
}
