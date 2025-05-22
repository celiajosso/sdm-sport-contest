package org.example;


public class Sport {
    private String name;
    private SportType type;

    public enum SportType {
        FOOTBALL, VOLLEYBALL, TENNIS
    }

    public Sport(String name, SportType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public SportType getType() {
        return type;
    }


}
