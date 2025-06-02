package org.example.contestant;

public class Player extends Contestant {
    private String firstname;
    private String surname;
    private String birthdate;

    public Player(String firstname, String surname, String birthdate) {
        this.firstname = firstname;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getBirthDate() {
        return this.birthdate;
    }

    public String getFullname() {
        return this.getFirstname() + " " + this.getSurname();
    }
}