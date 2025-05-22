package org.example;

import java.util.List;
import java.util.ArrayList;


public class Tournament {
    private Sport sport;
    private List<Phase> phases;
    private List<Contestant> contestants;

    public Tournament(Sport sport, List<Contestant> contestants) {
        this.sport = sport;
        this.contestants = contestants;
        this.phases = new ArrayList<>();
    }

    public void addPhase(Phase phase) {
        phases.add(phase);
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }

    public Sport getSport() {
        return sport;
    }
}
