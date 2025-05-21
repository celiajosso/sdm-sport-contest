package org.example.contestant;

public class Player extends Contestant {
    private String firstname;
    private String surname;
    private String pseudonym;
    private String birthdate;

    public Player(String  firstname, String surname, String pseudonym, String birthdate) {
        this.firstname = firstname;
        this.surname = surname;
        this.pseudonym = pseudonym;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPseudonym() {
        return this.pseudonym;
    }

    public String getBirthDate() {
        return this.birthdate;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }
}