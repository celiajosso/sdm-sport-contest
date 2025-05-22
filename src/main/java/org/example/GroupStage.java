package org.example;

public class GroupStage extends Phase {
    private Map<Contestant, Integer> points;

    public GroupStage(List<Contestant> contestants) {
        super(true);
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

    @Override
    public void onMatchFinished(Match match) {

    }
}
