// simulate a big tournament (groupPhase + knockout)
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.example.GroupStage;
import org.example.Match;
import org.example.SingleEliminationKnockout;
import org.example.Sport;
import org.example.Tournament;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;
import org.example.Events.Football.GoalScore;
import org.example.Events.Football.MatchEnd;
import org.example.MatchManager.FootballMatchManager;

public class TestFootball2 {

    public static void main(String[] args) {

         // === Create 8 Teams
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
    
        TeamMember t9a = new TeamMember("Quinn", "India", "01/01/2000", "FW");
        TeamMember t9b = new TeamMember("Ray", "India", "01/01/2000", "GK");
        Team team9 = new Team("Team India", t9a, new TeamMember[]{t9a, t9b});

        TeamMember t10a = new TeamMember("Sara", "Juliet", "01/01/2000", "FW");
        TeamMember t10b = new TeamMember("Tom", "Juliet", "01/01/2000", "GK");
        Team team10 = new Team("Team Juliet", t10a, new TeamMember[]{t10a, t10b});

        TeamMember t11a = new TeamMember("Uma", "Kilo", "01/01/2000", "FW");
        TeamMember t11b = new TeamMember("Vic", "Kilo", "01/01/2000", "GK");
        Team team11 = new Team("Team Kilo", t11a, new TeamMember[]{t11a, t11b});

        TeamMember t12a = new TeamMember("Walt", "Lima", "01/01/2000", "FW");
        TeamMember t12b = new TeamMember("Xena", "Lima", "01/01/2000", "GK");
        Team team12 = new Team("Team Lima", t12a, new TeamMember[]{t12a, t12b});

        TeamMember t13a = new TeamMember("Yara", "Mike", "01/01/2000", "FW");
        TeamMember t13b = new TeamMember("Zack", "Mike", "01/01/2000", "GK");
        Team team13 = new Team("Team Mike", t13a, new TeamMember[]{t13a, t13b});

        TeamMember t14a = new TeamMember("Adam", "November", "01/01/2000", "FW");
        TeamMember t14b = new TeamMember("Beth", "November", "01/01/2000", "GK");
        Team team14 = new Team("Team November", t14a, new TeamMember[]{t14a, t14b});

        TeamMember t15a = new TeamMember("Carl", "Oscar", "01/01/2000", "FW");
        TeamMember t15b = new TeamMember("Dina", "Oscar", "01/01/2000", "GK");
        Team team15 = new Team("Team Oscar", t15a, new TeamMember[]{t15a, t15b});

        TeamMember t16a = new TeamMember("Eli", "Papa", "01/01/2000", "FW");
        TeamMember t16b = new TeamMember("Fay", "Papa", "01/01/2000", "GK");
        Team team16 = new Team("Team Papa", t16a, new TeamMember[]{t16a, t16b});
        
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
        allContestants.add(team9);
        allContestants.add(team10);
        allContestants.add(team11);
        allContestants.add(team12);
        allContestants.add(team13);
        allContestants.add(team14);
        allContestants.add(team15);
        allContestants.add(team16);


        // List<Team> teams = FootballTeamDataLoader.loadTeams("FootballTeam.json");
        // List<Contestant> allContestants = new ArrayList<>(teams);

        Tournament tournament = new Tournament(Sport.FOOTBALL, allContestants);

        GroupStage[] groups = tournament.createGroupStage(4, false);

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

                System.out.println(teamA.getFullname() + " " + scoreA + " - " + scoreB + " " + teamB.getFullname());

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
            System.out.println(); 
        }

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

        // int l = qualified.size();
        // System.out.println("Qualified teams for "+l/2+"e of finals:");
        // qualified.forEach(c -> System.out.println(c.getFullname()));

        SingleEliminationKnockout knockout = null;

        while (qualified.size() > 2) {
                knockout = tournament.createKnockout(qualified);
                knockout.setContestants(qualified);

                int l = qualified.size();
                System.out.println("Qualified teams for 1/"+l/2+" finals:");
                qualified.forEach(c -> System.out.println(c.getFullname()));
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

                List<Team> winners = new ArrayList<>();
                for (Match match : knockout.getMatches()) {
                        if (match == null) continue;

                        Team winner = (Team) match.getMatchManager().getWinner();
                        winners.add(winner);
                }

                qualified.clear();
                qualified.addAll(winners);
        }

       
        System.out.println("Qualified teams for the final:");
        qualified.forEach(c -> System.out.println(c.getFullname()));
        Match[] knockoutMatches = knockout.getMatches();


        int lastMatchIndex = knockoutMatches.length - 1;
        int secondLastMatchIndex = knockoutMatches.length - 2;

        Team winner1 = (Team) knockoutMatches[secondLastMatchIndex].getMatchManager().getWinner();
        Team winner2 = (Team) knockoutMatches[lastMatchIndex].getMatchManager().getWinner();

        Match finalMatch = new Match(7, Sport.FOOTBALL, winner1, winner2, "03/06/2025", "Final Arena");
        FootballMatchManager finalManager = (FootballMatchManager) finalMatch.getMatchManager();

        int finalScoreA = rand.nextInt(5);
        int finalScoreB = rand.nextInt(5);

        for (int i = 0; i < finalScoreA; i++) {
        new GoalScore(finalMatch, finalManager, winner1).execute();
        }
        for (int i = 0; i < finalScoreB; i++) {
        new GoalScore(finalMatch, finalManager, winner2).execute();
        }

        if (finalScoreA == finalScoreB) {
        System.out.println("Draw! Simulating overtime or penalties...");
        new GoalScore(finalMatch, finalManager, winner1).execute(); // simple tiebreaker
        }

        new MatchEnd(finalMatch, finalManager).execute();


                System.out.println("\n=== FINAL ===");
                // System.out.println("Match: " + winnerSF1.getFullname() + " vs " + winnerSF2.getFullname());
                System.out.println("Final Score: " + finalManager.getScoreDisplay());
                Team tournamentWinner = (Team) finalManager.getWinner();
                System.out.println("Winner: " + tournamentWinner.getFullname());

                System.out.println("\n=== FINAL MATCH LOG ===");
                finalMatch.getEventLog().forEach(System.out::println);
        }
}
