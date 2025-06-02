package org.example;

import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStage<T> extends Phase {
    private final Map<Contestant, Integer> points;
    private List<Match> matches;

    public GroupStage(List<Contestant> contestants, Sport sport, boolean returnMatch) {
        super();
        this.points = new HashMap<>();

        for (Contestant c : contestants) {
            points.put(c, 0);
        }

        for (int i = 0; i < contestants.size(); i++) {
            for (int j = i + 1; j < contestants.size() + (contestants.size() > 2 ? 1 : 0); j++) {
                Contestant home = contestants.get(i);
                Contestant away = contestants.get(j % contestants.size());
                matches.add(new Match(1, sport, home, away, null, null));
                if (returnMatch) {
                    matches.add(new Match(1, sport, away, home, null, null));
                }
            }
        }
    }

    public void addPoints(Contestant contestant, int pts) {
        points.put(contestant, points.getOrDefault(contestant, 0) + pts);
    }

    public Map<Contestant, Integer> getRanking() {
        return points;
    }

    public void onMatchFinished(Match match) {
        for (Subscriber listener : listeners) {
            listener.notify(match);
        }
    }

    public Match[] getMatches() {
        return matches.toArray(new Match[0]);
    }
}
