package org.example.PhaseManager;

import org.example.GroupStage;
import org.example.SingleEliminationKnockout;
import org.example.Subscriber;
import org.example.contestant.Contestant;

import java.util.List;

public class PhaseManager implements Subscriber<GroupStage> {
    int[][] mapping;
    SingleEliminationKnockout knockout;

    public PhaseManager(SingleEliminationKnockout knockout, int[][] mapping) {
        this.mapping = mapping;
        this.knockout = knockout;
    }

    @Override
    public void notify(GroupStage group) {
        List<Contestant> contestant = group.getSortedContestants();
        int id = group.getId();

        int i = 0;
        for ( int k : mapping[id]) {
            knockout.setMatch(k,contestant.get(i++));
        }

    }
}