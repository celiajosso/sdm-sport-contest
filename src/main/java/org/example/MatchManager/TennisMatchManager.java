package org.example.MatchManager;

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

    public TennisMatchManager(Match match) {
        super(match);
    }

    public void pointScored(Player player) {
        int currentPoints = pointScores.getOrDefault(player, 0);
        Player opponent = getOpponent(player);
        int opponentPoints = pointScores.getOrDefault(opponent, 0);

        switch (currentPoints) {
            case 0 -> currentPoints = 15;
            case 15 -> currentPoints = 30;
            case 30 -> currentPoints = 40;
            case 40 -> {
                if (opponentPoints < 40) {
                    winGame(player);
                    return;
                } else if (opponentPoints == 40) {
                    pointScores.put(player, 41);
                    return;
                } else if (opponentPoints == 41) {
                    pointScores.put(opponent, 40);
                    return;
                }
            }
            case 41 -> {
                winGame(player);
                return;
            }
        }

        pointScores.put(player, currentPoints);
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
        } else {
            match.logEvent("Cannot cancel point: " + player.getPseudonym() + " already at 0");
        }
        match.logEvent("Cancelled point for " + player.getPseudonym() + ". Now at: " + pointScores.get(player));
    }

    public void winGame(Player player) {
        match.logEvent(player.getPseudonym() + " wins the game.");
        pointScores.clear();

        int games = gameScores.getOrDefault(player, 0) + 1;
        gameScores.put(player, games);
        match.logEvent(player.getPseudonym() + " now has " + games + " games.");

        Player opponent = getOpponent(player);
        if (games >= 6 && games - gameScores.getOrDefault(opponent, 0) >= 2) {
            winSet(player);
        }
    }

    public void winSet(Player player) {
        match.logEvent(player.getPseudonym() + " wins the set.");
        gameScores.clear();

        int sets = setScores.getOrDefault(player, 0) + 1;
        setScores.put(player, sets);
        match.logEvent(player.getPseudonym() + " now has " + sets + " sets.");

        if (sets == 2) {
            match.setState(org.example.MatchState.FINISHED);
            match.logEvent(player.getPseudonym() + " wins the match!");
        }
    }

    private Player getOpponent(Player player) {
        Team teamA = match.getTeamA();
        Team teamB = match.getTeamB();

        boolean playerInTeamA = Arrays.stream(teamA.getTeamMembers()).anyMatch(member -> member.equals(player));
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
            match.logEvent("Cancelled last game for " + player.getPseudonym() + ". Now at: " + (games - 1));
        } else {
            match.logEvent("Cannot cancel game: " + player.getPseudonym() + " has no games.");
        }
    }

    public void cancelLastSet(Player player) {
        int sets = setScores.getOrDefault(player, 0);
        if (sets > 0) {
            setScores.put(player, sets - 1);
            match.logEvent("Cancelled last set for " + player.getPseudonym() + ". Now at: " + (sets - 1));
        } else {
            match.logEvent("Cannot cancel set: " + player.getPseudonym() + " has no sets.");
        }
    }

    public void setSetsWon(Player player, int sets) {
        setsWon.put(player, sets);
    }

    public int getSetsWon(Player player) {
        return setsWon.getOrDefault(player, 0);
    }
}
