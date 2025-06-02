package org.example;

import org.example.PhaseManager.PhaseManager;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    Sport sport;
    List<Contestant> contestants;
    List<Phase> phases;

    PhaseManager phaseManager = new PhaseManager();

    public Tournament(Sport sport, List<Contestant> contestants, Match[] matches) {
        this.sport = sport;
        this.contestants = contestants;
        this.phases = new ArrayList<>();

        for (Match match : matches) {
            match.getMatchManager().getEventHistory().addSubscriber(phaseManager);
        }
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
