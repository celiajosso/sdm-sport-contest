package org.example;

import java.util.List;

import org.example.contestant.Contestant;

// faire design pattern composite
// compter nb de niveaux (puissance de 2)
public class SingleEliminationKnockout extends Phase {

    public SingleEliminationKnockout(List<Contestant> contestants, Sport sport, int[][] positionInTree) {
        super();
    }

    public void onMatchFinished(Match match) {
    }
}
