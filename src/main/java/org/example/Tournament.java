package org.example;

import org.example.PhaseManager.PhaseManager;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tournament {
    Sport sport;
    List<Contestant> contestants;
    List<GroupStage> groupStages = new ArrayList<>();

    public Tournament(Sport sport, List<Contestant> contestants) {
        this.sport = sport;
        this.contestants = contestants;
    }

    public GroupStage[] createGroupStage(int contestantPerGroup, boolean returnMatch) {
        List<Integer> shuffled = IntStream.range(0, contestants.size())
                .boxed()
                .collect(Collectors.toList()); // mutable list
        Collections.shuffle(shuffled);

        java.util.Collections.shuffle(shuffled);

        int k = 0;
        for (int i = 0; i < this.contestants.size() / contestantPerGroup; i++) {
            ArrayList<Contestant> contestants = new ArrayList<>();
            for (int j = 0; j < contestantPerGroup; j++) {
                contestants.add(this.contestants.get(shuffled.get(k++)));
            }
            GroupStage g = new GroupStage(i,contestants, sport, returnMatch);
            groupStages.add(g);
        }

        return getGroupStages().toArray(new GroupStage[0]);
    }

    public SingleEliminationKnockout createKnockout(int[][] positionInTree) {
        SingleEliminationKnockout knockout = new SingleEliminationKnockout(sport, positionInTree);

        PhaseManager phaseManager = new PhaseManager(knockout,positionInTree);

        for (GroupStage stage: this.groupStages) {
            stage.addListener(phaseManager);
        }
        
        return knockout;
    }

    public SingleEliminationKnockout createKnockout() {
        SingleEliminationKnockout knockout = new SingleEliminationKnockout(contestants, sport);
        return knockout;
    }

    public List<GroupStage> getGroupStages() {
        return groupStages;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }

    public Sport getSport() {
        return sport;
    }
}
