package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Phase {
    // attributs
    // - get scoreboard / leaderboard
    // - liste de matchs

    private List<Subscriber> listeners = new ArrayList<>();

    public void addListener(Subscriber subscriber) {
        this.listeners.add(subscriber);
    }
}
