package org.example.MatchManager;

import org.example.Events.Event;
import org.example.Events.Volleyball.TieBreak;
import org.example.Match;
import org.example.MatchState;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.util.HashMap;
import java.util.Map;

public class VolleyballMatchManager extends MatchManager {
    private final Map<Contestant, Integer> currentSetScore = new HashMap<>();
    private final Map<Contestant, Integer> setsWon = new HashMap<>();
    private int currentSetNumber = 1;

    public VolleyballMatchManager(Match match) {
        super(match);
        currentSetScore.put(match.getContestantA(), 0);
        currentSetScore.put(match.getContestantB(), 0);
        setsWon.put(match.getContestantA(), 0);
        setsWon.put(match.getContestantB(), 0);
    }

    public void pointScored(Team team) {
        Contestant opponent = (team == match.getContestantA()) ? match.getContestantB() : match.getContestantA();
        int newScore = currentSetScore.getOrDefault(team, 0) + 1;
        currentSetScore.put(team, newScore);

        int opponentScore = currentSetScore.getOrDefault(opponent, 0);
        int setTarget = (currentSetNumber == 5) ? 15 : 25;

        if (newScore >= setTarget && (newScore - opponentScore) >= 2) {
            winSet(team);
        }

        if (currentSetNumber == 5 && currentSetScore.values().stream().allMatch(score -> score == 0)) {
            applyVolleyBallEvent(new TieBreak(match));
        }
    }

    public void winSet(Team team) {
        int sets = setsWon.getOrDefault(team, 0) + 1;
        setsWon.put(team, sets);
        currentSetNumber++;

        currentSetScore.put(match.getContestantA(), 0);
        currentSetScore.put(match.getContestantB(), 0);

        if (sets == 3) {
            match.setState(MatchState.FINISHED);
        }

        if (currentSetNumber == 5) {
            applyVolleyBallEvent(new TieBreak(match));
        }
    }

    public void cancelLastPoint(Team team) {
        int score = currentSetScore.getOrDefault(team, 0);
        currentSetScore.put(team, score - 1);
    }

    public int getScore(Team team) {
        return currentSetScore.getOrDefault(team, 0);
    }

    public int getSetsWon(Team team) {
        return setsWon.getOrDefault(team, 0);
    }

    public void applyVolleyBallEvent(Event event) {
        applyEvent(event);
    }

    @Override
    public Contestant getWinner() {
        int setsTeamA = getSetsWon((Team) match.getContestantA());
        int setsTeamB = getSetsWon((Team) match.getContestantB());

        if (match.getState() != MatchState.FINISHED) {
            return null;
        }

        return (setsTeamA > setsTeamB) ? match.getContestantA() : match.getContestantB();
    }
}
