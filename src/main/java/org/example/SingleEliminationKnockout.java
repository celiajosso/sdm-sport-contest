package org.example;

import org.example.contestant.Contestant;

import java.util.List;

// faire design pattern composite
// compter nb de niveaux (puissance de 2)
public class SingleEliminationKnockout extends Phase {

    public SingleEliminationKnockout(List<Contestant> contestants, Sport sport, int[][] positionInTree) {
        super();
    }

    public void onMatchFinished(Match match) {
    }
}
