package org.example.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.Match;
import org.example.contestant.Contestant;

public class MatchComposite implements MatchComponent {
    private MatchComponent left;
    private MatchComponent right;
    private Match matchRoot;

    public Contestant execute() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$00"+left);

        Contestant leftContestant = left.execute();
        Contestant rightContestant = right.execute();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$11");

        if (leftContestant == null || rightContestant == null) {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$22");
            return null;

        }

        if (matchRoot == null) {
            matchRoot = new Match(1, left.getMatch().sport, leftContestant, rightContestant, null, null);
            return null;
        } else {
            // matchRoot.getWinner()
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$33");

            matchRoot.getMatchManager().getWinner();

            return null;
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

    @Override
public Match[] getAllMatches() {
    List<Match> all = new ArrayList<>();

    if (left != null) {
        all.addAll(Arrays.asList(left.getAllMatches()));
    }
    if (right != null) {
        all.addAll(Arrays.asList(right.getAllMatches()));
    }
    if (matchRoot != null) {
        all.add(matchRoot); 
    }
    return all.toArray(new Match[0]);
}


}
