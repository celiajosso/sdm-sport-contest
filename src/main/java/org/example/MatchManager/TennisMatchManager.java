package org.example.MatchManager;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Contestant;

import java.util.HashMap;
import java.util.Map;

public class TennisMatchManager extends MatchManager {
    private final Map<Contestant, Integer> pointScores = new HashMap<>();
    private final Map<Contestant, Integer> gameScores = new HashMap<>();
    private final Map<Contestant, Integer> setsWon = new HashMap<>();
    private final Map<Contestant, Integer> tieBreakPoints = new HashMap<>();
    private boolean isTieBreak = false;

    public TennisMatchManager(Match match) {
        super(match);
    }

    public void pointScored(Contestant player) {
        int currentPoints = pointScores.getOrDefault(player, 0);
        Contestant opponent = getOpponent(player);
        int opponentPoints = pointScores.getOrDefault(opponent, 0);

        if (isTieBreak) {
            int newPoints = tieBreakPoints.getOrDefault(player, 0) + 1;
            tieBreakPoints.put(player, newPoints);
            if (newPoints >= 7 && (newPoints - opponentPoints) >= 2) {
                winSet(player);
                isTieBreak = false;
                tieBreakPoints.clear();
            }
            return;
        }

        switch (currentPoints) {
            case 0 -> currentPoints = 15;
            case 15 -> currentPoints = 30;
            case 30 -> currentPoints = 40;
            case 40 -> {
                if (opponentPoints < 40) {
                    winGame(player);
                } else if (opponentPoints == 40) {
                    pointScores.put(player, 41);
                } else if (opponentPoints == 41) {
                    pointScores.put(opponent, 40);
                }
            }
            case 41 -> {
                winGame(player);
            }
        }
    }

    public void cancelLastPoint(Contestant player) {
        int currentPoints = pointScores.getOrDefault(player, 0);
        if (currentPoints == 41) {
            pointScores.put(player, 40);
        } else if (currentPoints == 40) {
            pointScores.put(player, 30);
        } else if (currentPoints == 30) {
            pointScores.put(player, 15);
        } else if (currentPoints == 15) {
            pointScores.put(player, 0);
        }
    }

    public void winGame(Contestant player) {
        match.logEvent(player.getFullname() + " wins the game.");
        pointScores.clear();

        int games = gameScores.getOrDefault(player, 0) + 1;
        gameScores.put(player, games);

        Contestant opponent = getOpponent(player);
        if (games >= 6 && games - gameScores.getOrDefault(opponent, 0) >= 2) {
            winSet(player);
        }

        if (games == 6 && gameScores.getOrDefault(getOpponent(player), 0) == 6) {
            isTieBreak = true;
        }
    }

    public void winSet(Contestant player) {
        match.logEvent(player.getFullname() + " wins the set.");
        gameScores.clear();

        int sets = getSetsWon(player) + 1;
        setSetsWon(player, sets);
        match.logEvent(player.getFullname() + " now has " + sets + " sets.");

        if (sets == 2) {
            match.setState(org.example.MatchState.FINISHED);
            match.logEvent(player.getFullname() + " wins the match!");
        }
    }

    private Contestant getOpponent(Contestant contestant) {
        Contestant teamA = match.getContestantA();
        Contestant teamB = match.getContestantB();

        return contestant == teamA ? teamB : teamA;
    }

    public void cancelLastGame(Contestant player) {
        int games = gameScores.getOrDefault(player, 0);
        if (games > 0) {
            gameScores.put(player, games - 1);
        }
    }

    public void cancelLastSet(Contestant player) {
        int sets = setsWon.getOrDefault(player, 0);
        if (sets > 0) {
            setsWon.put(player, sets - 1);
        }
    }

    public void setSetsWon(Contestant player, int sets) {
        setsWon.put(player, sets);
    }

    public int getSetsWon(Contestant player) {
        return setsWon.getOrDefault(player, 0);
    }

    public void applyTennisEvent(Event event) {
        applyEvent(event);
    }

    @Override
    public Contestant getWinner() {
        Contestant teamA = match.getContestantA();
        Contestant teamB = match.getContestantB();

        int setsA = getSetsWon(teamA);
        int setsB = getSetsWon(teamB);

        if (setsA > setsB) {
            return teamA;
        } else if (setsB > setsA) {
            return teamB;
        } else {
            return null; // match nul ou non terminé
        }
    }

}
