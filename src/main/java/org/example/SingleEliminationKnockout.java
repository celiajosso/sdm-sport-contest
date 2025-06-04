package org.example;

import org.example.composite.MatchComponent;
import org.example.composite.MatchComposite;
import org.example.composite.MatchLeaf;
import org.example.contestant.Contestant;
import org.example.Match;

import java.util.ArrayList;
import java.util.List;

// faire design pattern composite
// compter nb de niveaux (puissance de 2)
public class SingleEliminationKnockout extends Phase {
    private MatchComponent root;
    private List<Match> allMatches = new ArrayList<>();
    private List<Contestant> contestants;

    public SingleEliminationKnockout(List<Contestant> contestants, Sport sport) {
        super();
    
        if (Integer.bitCount(contestants.size()) != 1) {
            throw new IllegalArgumentException("Number of contestants must be a power of 2 (4, 8, 16, ...)");
        }
    
        this.root = buildTree(contestants, sport, 1);
    }
    



    private MatchComponent buildTree(List<Contestant> contestants, Sport sport, int matchIdStart) {
        List<MatchComponent> leaves = new ArrayList<>();
        int matchId = matchIdStart;
    
        for (int i = 0; i < contestants.size(); i += 2) {
            Match match = new Match(matchId++, sport, contestants.get(i), contestants.get(i + 1), "02/06/2025", "Stadium " + (i / 2 + 1));
            MatchLeaf leaf = new MatchLeaf(match);
            leaves.add(leaf);
            allMatches.add(match);
        }
    
        while (leaves.size() > 1) {
            List<MatchComponent> nextLevel = new ArrayList<>();
            for (int i = 0; i < leaves.size(); i += 2) {
                MatchComposite composite = new MatchComposite();
                composite.add(leaves.get(i));
                composite.add(leaves.get(i + 1));
                allMatches.add(composite.getMatch());
                nextLevel.add(composite);
            }
            leaves = nextLevel;
        }
    
        return leaves.get(0); // racine de l'arbre
    }
    




    public void onMatchFinished(Match match) {
        root.execute();
    }


    public void setContestants(List<Contestant> contestants) {
        this.contestants = contestants;
        
    }

    public Match[] getMatches() {
        return root.getAllMatches(); 
    }
    
}
