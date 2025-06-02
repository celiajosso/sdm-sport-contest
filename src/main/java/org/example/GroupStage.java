package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.contestant.Contestant;

public class GroupStage extends Phase {
    private Map<Contestant, Integer> points;

    public GroupStage(List<Contestant> contestants) {
        super();
        this.points = new HashMap<>();
        for (Contestant c : contestants) {
            points.put(c, 0);
        }
    }

    public void addPoints(Contestant contestant, int pts) {
        points.put(contestant, points.getOrDefault(contestant, 0) + pts);
    }

    public Map<Contestant, Integer> getRanking() {
        return points;
    }

    public void onMatchFinished(Match match) {

    }
}
