package org.example.contestant;

public class Player extends Contestant {
    private final String firstname;
    private final String surname;
    private final String birthdate;

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

    public void display() {
        System.out.println("Player name: " + getFullname());
    }
}