package org.example.composite;

import org.example.Match;
import org.example.contestant.Contestant;

public class MatchComposite implements MatchComponent {
    private MatchComponent left;
    private MatchComponent right;
    private Match matchRoot;

    public Contestant execute() {
        System.out.println(left);

        Contestant leftContestant = left.execute();
        Contestant rightContestant = right.execute();

        if (leftContestant == null || rightContestant == null) {
            return null;
        }

        if (matchRoot == null) {
            matchRoot = new Match(1, left.getMatch().sport, leftContestant, rightContestant, null, null);
            return null;
        } else {
            return matchRoot.getMatchManager().getWinner();
        }
    }

    public void add(MatchComponent matchComponent) {
        if (left == null) {
            left = matchComponent;
        } else if (right == null) {
            right = matchComponent;
        } else {
            throw new IllegalStateException("Cannot add more than two children to a MatchComposite");
        }
    }

    public void remove(MatchComponent matchComponent) {
        if (left == matchComponent) {
            left = null;
        } else if (right == matchComponent) {
            right = null;
        } else {
            throw new IllegalArgumentException("MatchComponent not found in this composite");
        }
    }

    public MatchComponent getLeft() {
        return left;
    }

    public MatchComponent getRight() {
        return right;
    }

    public Match getMatch() {
        return matchRoot;
    }
}
