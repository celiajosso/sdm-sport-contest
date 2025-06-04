package org.example;

import org.example.Events.Event;
import org.example.composite.MatchComponent;
import org.example.composite.MatchComposite;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.List;

// faire design pattern composite
// compter nb de niveaux (puissance de 2)
public class SingleEliminationKnockout extends Phase {
    private final MatchComponent root;
    private KnockoutManager knockoutManager = new KnockoutManager();

    private class KnockoutManager implements Subscriber<Event> {
        @Override
        public void notify(Event event) {
            if (event instanceof org.example.Events.Football.MatchEnd
                    || event instanceof org.example.Events.Volleyball.MatchEnd
                    || event instanceof org.example.Events.Tennis.MatchEnd) {
                root.execute();
            }
        }
    }

    public SingleEliminationKnockout(Sport sport, int[][] positionInTree) {
        super();
        int n = java.util.Arrays.stream(positionInTree).mapToInt(arr -> arr.length).sum() / 2;
        this.root = buildEmptyTree(n, sport);
    }

    public SingleEliminationKnockout(List<Contestant> contestants, Sport sport) {
        super();
        java.util.Collections.shuffle(contestants);
        int n = contestants.size();

        int leafCount = 1;
        while (leafCount < n)
            leafCount *= 2;

        List<Contestant> padded = new java.util.ArrayList<>(contestants);
        while (padded.size() < leafCount)
            padded.add(null);
        this.root = buildContestantTree(padded, sport);
    }

    public void onMatchFinished(Match match) {
        root.execute();
    }

    private MatchComponent buildEmptyTree(int leafCount, Sport sport) {
        if (leafCount == 1) {

            Match match = new Match(1, sport, null, null, null, null);

            return new org.example.composite.MatchLeaf(match);
        }
        MatchComposite node = new org.example.composite.MatchComposite();
        node.add(buildEmptyTree(leafCount / 2, sport));
        node.add(buildEmptyTree(leafCount / 2, sport));
        return node;
    }

    public void setMatch(int index, Contestant contestant) {
        List<org.example.composite.MatchLeaf> leaves = new ArrayList<>();
        collectLeaves(root, leaves);

        int leafIndex = index / 2;
        boolean isA = index % 2 == 0;

        if (leafIndex < 0 || leafIndex >= leaves.size()) {
            throw new IllegalArgumentException("Index de feuille invalide");
        }

        org.example.composite.MatchLeaf leaf = leaves.get(leafIndex);
        Match match = leaf.getMatch();

        if (isA) {
            match.setContestantA(contestant);
        } else {
            match.setContestantB(contestant);
        }
    }

    private void collectLeaves(MatchComponent node, List<org.example.composite.MatchLeaf> leaves) {
        if (node instanceof org.example.composite.MatchLeaf leaf) {
            leaves.add(leaf);
        } else if (node instanceof MatchComposite composite) {
            collectLeaves(composite.getLeft(), leaves);
            collectLeaves(composite.getRight(), leaves);
        }
    }

    private MatchComponent buildContestantTree(List<Contestant> contestants, Sport sport) {
        int n = contestants.size();
        if (n == 2) {
            Contestant c1 = contestants.get(0);
            Contestant c2 = contestants.get(1);
            if (c1 == null)
                return new org.example.composite.MatchLeaf(null);
            if (c2 == null)
                return new org.example.composite.MatchLeaf(null);
            Match match = new Match(1, sport, c1, c2, null, null);
            match.getMatchManager().addSubscriber(knockoutManager);
            return new org.example.composite.MatchLeaf(match);
        }
        int mid = n / 2;
        MatchComposite node = new org.example.composite.MatchComposite();
        node.add(buildContestantTree(contestants.subList(0, mid), sport));
        node.add(buildContestantTree(contestants.subList(mid, n), sport));
        return node;
    }

    public void displayPhase() {
        printComponent(root, 0);
    }

    private void printComponent(MatchComponent component, int depth) {
        String indent = "  ".repeat(depth);
        if (component instanceof org.example.composite.MatchLeaf leaf) {
            Match match = leaf.getMatch();
            if (match == null) {
                System.out.println(indent + "Leaf: [empty]");
            } else {
                String a = match.getContestantA() != null ? match.getContestantA().getFullname() : "null";
                String b = match.getContestantB() != null ? match.getContestantB().getFullname() : "null";
                String winner = match.getMatchManager().getWinner() != null ? match.getMatchManager().getWinner().getFullname() : "TBD";
                System.out.println(indent + "Match: " + a + " vs " + b + " | Winner: " + winner);
            }
        } else if (component instanceof MatchComposite composite) {
            Match match = composite.getMatch();
            if (match != null) {
                String a = match.getContestantA() != null ? match.getContestantA().getFullname() : "null";
                String b = match.getContestantB() != null ? match.getContestantB().getFullname() : "null";
                String winner = match.getMatchManager().getWinner() != null ? match.getMatchManager().getWinner().getFullname() : "TBD";
                System.out.println(indent + "Match: " + a + " vs " + b + " | Winner: " + winner);
            } else {
                System.out.println(indent + "Node: [no match]");
            }
            printComponent(composite.getLeft(), depth + 1);
            printComponent(composite.getRight(), depth + 1);
        } else {
            System.out.println(indent + "Unknown component");
        }
    }

    public List<Match> getMatchesAtDepth(int depth) {
        List<Match> result = new ArrayList<>();
        collectMatchesAtDepth(root, depth, 0, result);
        return result;
    }

    private void collectMatchesAtDepth(MatchComponent node, int targetDepth, int currentDepth, List<Match> result) {
        if (node == null)
            return;
        if (currentDepth == targetDepth) {
            result.add(node.getMatch());
        } else if (node instanceof org.example.composite.MatchComposite composite) {
            collectMatchesAtDepth(composite.getLeft(), targetDepth, currentDepth + 1, result);
            collectMatchesAtDepth(composite.getRight(), targetDepth, currentDepth + 1, result);
        }
    }

}
