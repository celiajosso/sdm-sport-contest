package org.example;



public class SingleEliminationKnockout extends Phase {
    private Match rootMatch; 

    public SingleEliminationKnockout(Match finalMatch) {
        super(false);
        this.rootMatch = finalMatch;
    }

    public Match getRootMatch() {
        return rootMatch;
    }

    @Override
    public void onMatchFinished(Match match) {
    }
}
