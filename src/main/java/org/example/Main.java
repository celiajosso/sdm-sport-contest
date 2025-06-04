package org.example;

import org.example.Events.Football.GoalScore;
import org.example.Events.Football.MatchEnd;
import org.example.MatchManager.FootballMatchManager;
import org.example.composite.MatchComposite;
import org.example.composite.MatchLeaf;
import org.example.contestant.Contestant;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.example.Sport.FOOTBALL;

public class Main {


    public static void main(String[] args) {

        // === Create 8 Teams with 2 players each (FW and GK) ===
        TeamMember t1a = new TeamMember("Alice", "Alpha", "01/01/2000", "FW");
        TeamMember t1b = new TeamMember("Bob", "Alpha", "01/01/2000", "GK");
        Team team1 = new Team("Team Alpha", t1a, new TeamMember[]{t1a, t1b});
    
        TeamMember t2a = new TeamMember("Carl", "Bravo", "01/01/2000", "FW");
        TeamMember t2b = new TeamMember("Dana", "Bravo", "01/01/2000", "GK");
        Team team2 = new Team("Team Bravo", t2a, new TeamMember[]{t2a, t2b});
    
        TeamMember t3a = new TeamMember("Eve", "Charlie", "01/01/2000", "FW");
        TeamMember t3b = new TeamMember("Frank", "Charlie", "01/01/2000", "GK");
        Team team3 = new Team("Team Charlie", t3a, new TeamMember[]{t3a, t3b});
    
        TeamMember t4a = new TeamMember("Grace", "Delta", "01/01/2000", "FW");
        TeamMember t4b = new TeamMember("Hank", "Delta", "01/01/2000", "GK");
        Team team4 = new Team("Team Delta", t4a, new TeamMember[]{t4a, t4b});
    
        TeamMember t5a = new TeamMember("Ivy", "Echo", "01/01/2000", "FW");
        TeamMember t5b = new TeamMember("Jack", "Echo", "01/01/2000", "GK");
        Team team5 = new Team("Team Echo", t5a, new TeamMember[]{t5a, t5b});
    
        TeamMember t6a = new TeamMember("Kim", "Foxtrot", "01/01/2000", "FW");
        TeamMember t6b = new TeamMember("Leo", "Foxtrot", "01/01/2000", "GK");
        Team team6 = new Team("Team Foxtrot", t6a, new TeamMember[]{t6a, t6b});
    
        TeamMember t7a = new TeamMember("Mia", "Golf", "01/01/2000", "FW");
        TeamMember t7b = new TeamMember("Ned", "Golf", "01/01/2000", "GK");
        Team team7 = new Team("Team Golf", t7a, new TeamMember[]{t7a, t7b});
    
        TeamMember t8a = new TeamMember("Oscar", "Hotel", "01/01/2000", "FW");
        TeamMember t8b = new TeamMember("Pam", "Hotel", "01/01/2000", "GK");
        Team team8 = new Team("Team Hotel", t8a, new TeamMember[]{t8a, t8b});
    
        // === Create a list of all teams (Contestants) ===
        List<Contestant> allContestants = new ArrayList<>();
        allContestants.add(team1);
        allContestants.add(team2);
        allContestants.add(team3);
        allContestants.add(team4);
        allContestants.add(team5);
        allContestants.add(team6);
        allContestants.add(team7);
        allContestants.add(team8);
    
        // === Create the tournament with all contestants ===
        Tournament tournament = new Tournament(FOOTBALL, allContestants);
    
        // === Create 2 groups (4 teams each), no return match ===
        GroupStage[] groups = tournament.createGroupStage(4, false);
    
        // === Simulate all group matches (with goals and points) ===
        Random rand = new Random();
        for (GroupStage group : groups) {
            System.out.println("=== Group Match Simulation ===");
            for (Match match : group.getMatches()) {
                System.out.println("---------------------------------------------------------------");
                FootballMatchManager manager = (FootballMatchManager) match.getMatchManager();
    
                Team teamA = (Team) match.getTeamA();
                Team teamB = (Team) match.getTeamB();
    
                int scoreA = rand.nextInt(5);
                int scoreB = rand.nextInt(5);
    
                for (int i = 0; i < scoreA; i++) {
                    new GoalScore(match, manager, teamA).execute();
                }
                for (int i = 0; i < scoreB; i++) {
                    new GoalScore(match, manager, teamB).execute();
                }
    
                new MatchEnd(match, manager).execute();
    
                System.out.println(match.getTeamA().getFullname() + " " + scoreA + " - " + scoreB + " " + match.getTeamB().getFullname());
    
                // Assign points according to score
                if (scoreA > scoreB) {
                    group.addPoints(teamA, 3);
                } else if (scoreA < scoreB) {
                    group.addPoints(teamB, 3);
                } else {
                    group.addPoints(teamA, 1);
                    group.addPoints(teamB, 1);
                }
    
                group.onMatchFinished(match);
            }
            System.out.println(); // Group separation
        }
    
        // === Get top 2 teams from each group ===
        List<Contestant> qualified = new ArrayList<>();
        for (GroupStage group : groups) {
            List<Map.Entry<Contestant, Integer>> ranking = new ArrayList<>(group.getRanking().entrySet());
            ranking.sort((a, b) -> b.getValue() - a.getValue());
    
            System.out.println("Group Ranking:");
            for (Map.Entry<Contestant, Integer> entry : ranking) {
                System.out.println(entry.getKey().getFullname() + " - " + entry.getValue() + " points");
            }
            System.out.println();
    
            qualified.add(ranking.get(0).getKey());
            qualified.add(ranking.get(1).getKey());
        }
    
        // === Print qualified teams for semifinals ===
        System.out.println("Qualified teams for semi-finals:");
        qualified.forEach(c -> System.out.println(c.getFullname()));
    
        // === Create knockout phase with 4 qualified teams ===
        // int[][] positionInTree = { {0,1}, {2,3} };
        SingleEliminationKnockout knockout = tournament.createKnockout(qualified);
        knockout.setContestants(qualified);
    
        // === Simulate semi-final matches with random goals ===
        for (Match match : knockout.getMatches()) {
            if (match == null) continue;
    
            FootballMatchManager manager = (FootballMatchManager) match.getMatchManager();
            System.out.println("Match : " + match.getTeamA().getFullname() + " vs " + match.getTeamB().getFullname());
    
            int scoreA = rand.nextInt(5);
            int scoreB = rand.nextInt(5);
    
            for (int i = 0; i < scoreA; i++) {
                new GoalScore(match, manager, (Team) match.getTeamA()).execute();
            }
            for (int i = 0; i < scoreB; i++) {
                new GoalScore(match, manager, (Team) match.getTeamB()).execute();
            }
    
            if (scoreA == scoreB) {
                System.out.println("Draw! Simulating overtime or penalties...");
                new GoalScore(match, manager, (Team) match.getTeamA()).execute(); // simple tiebreaker
            }
    
            new MatchEnd(match, manager).execute();
            System.out.println("Final score: " + manager.getScoreDisplay());
        }
    
        // === Retrieve winners of semi-finals ===
        Match semiFinal1 = knockout.getMatches()[0];
        Match semiFinal2 = knockout.getMatches()[1];
    
        Team winnerSF1 = (Team) semiFinal1.getMatchManager().getWinner();
        Team winnerSF2 = (Team) semiFinal2.getMatchManager().getWinner();
    
        // === Create and simulate the final ===
        Match finalMatch = new Match(7, FOOTBALL, winnerSF1, winnerSF2, "03/06/2025", "Final Arena");
        FootballMatchManager finalManager = (FootballMatchManager) finalMatch.getMatchManager();
    
        int finalScoreA = rand.nextInt(5);
        int finalScoreB = rand.nextInt(5);
    
        for (int i = 0; i < finalScoreA; i++) {
            new GoalScore(finalMatch, finalManager, winnerSF1).execute();
        }
        for (int i = 0; i < finalScoreB; i++) {
            new GoalScore(finalMatch, finalManager, winnerSF2).execute();
        }
    
        if (finalScoreA == finalScoreB) {
            System.out.println("Draw! Simulating overtime or penalties...");
            new GoalScore(finalMatch, finalManager, winnerSF1).execute(); // simple tiebreaker
        }
    
        new MatchEnd(finalMatch, finalManager).execute();
    
        // === Display final results ===
        System.out.println("\n=== FINAL ===");
        System.out.println("Match: " + winnerSF1.getFullname() + " vs " + winnerSF2.getFullname());
        System.out.println("Final Score: " + finalManager.getScoreDisplay());
        Team tournamentWinner = (Team) finalManager.getWinner();
        System.out.println("Winner: " + tournamentWinner.getFullname());
    
        // === Print final match event log ===
        System.out.println("\n=== FINAL MATCH LOG ===");
        finalMatch.getEventLog().forEach(System.out::println);
    }
    














}
