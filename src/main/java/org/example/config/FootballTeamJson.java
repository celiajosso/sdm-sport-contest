package org.example.config;

public class FootballTeamJson {
    public String name;

    public static class Player {
        public String firstName;
        public String lastName;
        public String birthdate;
        public String role;
        public Boolean isLeader;
    }
}
