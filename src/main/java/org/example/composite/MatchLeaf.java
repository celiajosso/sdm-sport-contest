package org.example.composite;

import org.example.Match;
import org.example.MatchState;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

public class MatchLeaf implements MatchComponent {
    private Match match;

    public MatchLeaf(Match match) {
        this.match = match;
    }

    @Override
    public Contestant execute() {
        if (match.getMatchManager() instanceof FootballMatchManager) {
            FootballMatchManager manager = (FootballMatchManager) match.getMatchManager();
            System.out.println("Leaf Manager : "+manager);
            Team winnerSemiFinal2 = (Team) manager.getWinner();
                System.out.println("Gagnant du match leaf: " + winnerSemiFinal2);
            int scoreA = manager.getScoreA();
            int scoreB = manager.getScoreB();
            System.out.println("Score : " + scoreA + " - " + scoreB);
        }
        if (match != null) {
            if (match.getState() == MatchState.FINISHED) {
                // System.out.println("Gagnant du match leaf: " + match.getMatchManager().getWinner());
                FootballMatchManager managerZ = (FootballMatchManager) match.getMatchManager();
                Team winnerSemiFinal2 = (Team) managerZ.getWinner();
                System.out.println("Gagnant du match leaf: " + winnerSemiFinal2);

                return match.getMatchManager().getWinner();
            } else {
                throw new IllegalStateException("Match n'a pas commence");

                // return null;
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

    public Match[] getAllMatches() {
        return new Match[]{this.match};
    }
}