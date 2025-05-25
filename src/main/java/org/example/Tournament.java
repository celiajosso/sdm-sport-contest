package org.example;

import org.example.PhaseManager.PhaseManager;
import org.example.contestant.Contestant;

import java.util.HashMap;
import java.util.List;

public class Tournament {
    Sport sport;
    List<Contestant> contestants;
    HashMap<String,Phase> phases = new HashMap<>();

    PhaseManager phaseManager = new PhaseManager();

    Tournament(Sport sport, List<Contestant> contestants, List<Match> matches, HashMap<String,String> mapping ){
        this.contestants = contestants;
        this.sport = sport;
    }

    Tournament(Sport sport, List<Contestant> contestants, List<Match> matches){
        this.contestants = contestants;
        this.sport = sport;

        Phase knockout = new SingleEliminationKnockout(matches);

        for (Match match : matches) {
            match.getMatchManager().getEventHistory().addSubscriber(phaseManager);
        }
        phases.put("knockout", knockout);
    }
}
