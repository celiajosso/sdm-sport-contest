package org.example;

// faire builder
// compter nb de niveaux (puissance de 2)
public class SingleEliminationKnockout extends Phase {
    private Match rootMatch;

    public SingleEliminationKnockout(Match finalMatch) {
        super();
        this.rootMatch = finalMatch;
    }

    public Match getRootMatch() {
        return rootMatch;
    }

    public void onMatchFinished(Match match) {
    }
}
