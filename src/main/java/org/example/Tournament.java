package org.example;

import org.example.PhaseManager.PhaseManager;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    GroupStage[] createGroupeStage(int contestantPerGroup, boolean returnMatch) {
        GroupStage[] stages = new GroupStage[this.contestants.size() / contestantPerGroup];

        List<Integer> shuffled = IntStream.rangeClosed(1, 9).boxed().toList();
        java.util.Collections.shuffle(shuffled);

        int k = 0;
        for (int i = 0; i < stages.length; i++) {
            ArrayList<Contestant> contestants = new ArrayList<>();
            for (int j = 0; j < contestantPerGroup; j++) {
                contestants.add(this.contestants.get(shuffled.get(k++)));
            }
            stages[i] = new GroupStage(contestants,sport,returnMatch);
        }

        return stages;
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
