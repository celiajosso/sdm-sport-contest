package org.example;

public class Sport {
    private SportType type;

    public enum SportType {
        FOOTBALL, VOLLEYBALL, TENNIS
    }

    public Sport(SportType type) {
        this.type = type;
    }

    public SportType getType() {
        return type;
    }
}
