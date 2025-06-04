package org.example.composite;

import org.example.Match;
import org.example.MatchManager.FootballMatchManager;
import org.example.MatchState;
import org.example.contestant.Contestant;

public class MatchLeaf implements MatchComponent {
    private Match match;

    public MatchLeaf(Match match) {
        this.match = match;
    }

    @Override
    public Contestant execute() {
        if (match.getMatchManager() instanceof FootballMatchManager manager) {
            int scoreA = manager.getScoreA();
            int scoreB = manager.getScoreB();
            System.out.println("Score : " + scoreA + " - " + scoreB);
        }
        if (match != null) {
            if (match.getState() == MatchState.FINISHED) {
                return match.getMatchManager().getWinner();
            } else {
                return null;
            }
        } else {
            throw new IllegalStateException("Match is not set");
        }
    }

    @Override
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}