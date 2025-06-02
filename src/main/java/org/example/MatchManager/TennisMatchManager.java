package org.example.MatchManager;

import org.example.Events.Event;
import org.example.Match;
import org.example.contestant.Player;
import org.example.contestant.Team;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TennisMatchManager extends MatchManager {
    private final Map<Player, Integer> pointScores = new HashMap<>();
    private final Map<Player, Integer> gameScores = new HashMap<>();
    private final Map<Player, Integer> setScores = new HashMap<>();
    private final Map<Player, Integer> setsWon = new HashMap<>();
    private final Map<Player, Integer> tieBreakPoints = new HashMap<>();
    private boolean isTieBreak = false;

    public TennisMatchManager(Match match) {
        super(match);
    }

    public void pointScored(Player player) {
        int currentPoints = pointScores.getOrDefault(player, 0);
        Player opponent = getOpponent(player);
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

    public void cancelLastPoint(Player player) {
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

    public void winGame(Player player) {
        match.logEvent(player.getFullname() + " wins the game.");
        pointScores.clear();

        int games = gameScores.getOrDefault(player, 0) + 1;
        gameScores.put(player, games);

        Player opponent = getOpponent(player);
        if (games >= 6 && games - gameScores.getOrDefault(opponent, 0) >= 2) {
            winSet(player);
        }

        if (games == 6 && gameScores.getOrDefault(getOpponent(player), 0) == 6) {
            isTieBreak = true;
        }
    }

    public void winSet(Player player) {
        match.logEvent(player.getFullname() + " wins the set.");
        gameScores.clear();

        int sets = setScores.getOrDefault(player, 0) + 1;
        setScores.put(player, sets);
        match.logEvent(player.getFullname() + " now has " + sets + " sets.");

        if (sets == 2) {
            match.setState(org.example.MatchState.FINISHED);
            match.logEvent(player.getFullname() + " wins the match!");
        }
    }

    private Player getOpponent(Player player) {
        Team teamA = (Team) match.getTeamA();
        Team teamB = (Team) match.getTeamB();

        boolean playerInTeamA = Arrays.asList(teamA.getTeamMembers()).contains(player);
        if (playerInTeamA) {
            return teamB.getTeamMembers()[0];
        } else {
            return teamA.getTeamMembers()[0];
        }
    }

    public void cancelLastGame(Player player) {
        int games = gameScores.getOrDefault(player, 0);
        if (games > 0) {
            gameScores.put(player, games - 1);
        }
    }

    public void cancelLastSet(Player player) {
        int sets = setScores.getOrDefault(player, 0);
        if (sets > 0) {
            setScores.put(player, sets - 1);
        }
    }

    public void setSetsWon(Player player, int sets) {
        setsWon.put(player, sets);
    }

    public int getSetsWon(Player player) {
        return setsWon.getOrDefault(player, 0);
    }

    public void applyTennisEvent(Event event) {
        applyEvent(event);
    }
}
