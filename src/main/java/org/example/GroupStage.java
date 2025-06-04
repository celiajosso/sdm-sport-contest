package org.example;

import org.example.Events.Event;
import org.example.contestant.Contestant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStage extends Phase {
    private final Map<Contestant, Integer> points;
    private final List<Match> matches = new ArrayList<>();
    private final int id;
    private GroupManager manager = new GroupManager();

    public GroupStage(int id, List<Contestant> contestants, Sport sport, boolean returnMatch) {
        super();
        this.points = new HashMap<>();
        this.id = id;
        for (Contestant c : contestants) {
            points.put(c, 0);
        }

        for (int i = 0; i < contestants.size(); i++) {
            for (int j = i + 1; j < contestants.size(); j++) {
                Contestant home = contestants.get(i);
                Contestant away = contestants.get(j % contestants.size());
                Match m1 = new Match(1, sport, home, away, null, null);
                m1.getMatchManager().addSubscriber(manager);
                matches.add(m1);
                if (returnMatch) {
                    Match m2 = new Match(1, sport, away, home, null, null);
                    m2.getMatchManager().addSubscriber(manager);
                    matches.add(m2);
                }
            }
        }
    }

    public int getId() {
        return id;
    }

    public void addPoints(Contestant contestant, int pts) {
        points.put(contestant, points.getOrDefault(contestant, 0) + pts);
    }

    public Map<Contestant, Integer> getRanking() {
        return points;
    }

    public List<Contestant> getSortedContestants() {
        return points.entrySet()
                .stream()
                .sorted(Map.Entry.<Contestant, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }

    public void onPhaseFinish() {
        for (Subscriber<GroupStage> listener : listeners) {
            listener.notify(this);
        }
    }

    public Match[] getMatches() {
        return matches.toArray(new Match[0]);
    }

    public void displayPhase() {
        for (Match m : this.getMatches()) {
            System.out.println("  " + m.getContestantA().getFullname() + " vs. "
                    + m.getContestantB().getFullname());
        }
    }

    /**
     * Pretty display of the group ranking as a table.
     */
    public void displayRanking() {
        System.out.println("\nGroup " + (id + 1) + " Ranking");
        List<Map.Entry<Contestant, Integer>> sorted = points.entrySet()
                .stream()
                .sorted(Map.Entry.<Contestant, Integer>comparingByValue().reversed())
                .toList();
        int pos = 1;
        for (Map.Entry<Contestant, Integer> entry : sorted) {
            System.out.printf("%-3d | %-10s | %-1d points\n", pos++, entry.getKey().getFullname(), entry.getValue());
        }
    }

    private class GroupManager implements Subscriber<Event> {
        @Override
        public void notify(Event event) {
            if (event instanceof org.example.Events.Football.MatchEnd
                    || event instanceof org.example.Events.Volleyball.MatchEnd
                    || event instanceof org.example.Events.Tennis.MatchEnd) {
                Contestant winner = event.getMatch().getMatchManager().getWinner();
                if (winner == null) {
                    Contestant contestantA = event.getMatch().getContestantA();
                    points.put(contestantA, points.getOrDefault(contestantA, 0) + 1);

                    Contestant contestantB = event.getMatch().getContestantB();
                    points.put(contestantB, points.getOrDefault(contestantB, 0) + 1);
                } else {
                    points.put(winner, points.getOrDefault(winner, 0) + 3);
                }
            }
            for (Match m : matches) {
                if (m.getState() != MatchState.FINISHED) {
                    return;
                }
            }
            onPhaseFinish();
        }
    }

    public List<Contestant> getQualified(int n) {
        return getSortedContestants().subList(0, Math.min(n, getSortedContestants().size()));
    }
    
}
