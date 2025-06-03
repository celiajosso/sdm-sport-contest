package org.example;

import org.example.Events.Football.GoalScore;
import org.example.Events.Football.MatchEnd;
import org.example.MatchManager.FootballMatchManager;
import org.example.composite.MatchComposite;
import org.example.composite.MatchLeaf;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

import java.util.List;

import static org.example.Sport.FOOTBALL;

public class Main {
    public static void main(String[] args) {
        // === Création des équipes ===
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

// === Création des quarts de finale ===
Match qf1 = new Match(1, FOOTBALL, team1, team2, "01/06/2025", "QF Stadium 1");
FootballMatchManager qfManager1 = (FootballMatchManager) qf1.getMatchManager();

Match qf2 = new Match(2, FOOTBALL, team3, team4, "01/06/2025", "QF Stadium 2");
FootballMatchManager qfManager2 = (FootballMatchManager) qf2.getMatchManager();

Match qf3 = new Match(3, FOOTBALL, team5, team6, "01/06/2025", "QF Stadium 3");
FootballMatchManager qfManager3 = (FootballMatchManager) qf3.getMatchManager();

Match qf4 = new Match(4, FOOTBALL, team7, team8, "01/06/2025", "QF Stadium 4");
FootballMatchManager qfManager4 = (FootballMatchManager) qf4.getMatchManager();

// === Simulation des quarts ===
// QF1 : Team Alpha 2 - 1 Team Bravo
new GoalScore(qf1, qfManager1, team1).execute();
new GoalScore(qf1, qfManager1, team1).execute();
new GoalScore(qf1, qfManager1, team2).execute();
new MatchEnd(qf1, qfManager1).execute();

// QF2 : Team Delta 1 - 0 Team Charlie
new GoalScore(qf2, qfManager2, team4).execute();
new MatchEnd(qf2, qfManager2).execute();

// QF3 : Team Echo 3 - 2 Team Foxtrot
new GoalScore(qf3, qfManager3, team5).execute();
new GoalScore(qf3, qfManager3, team5).execute();
new GoalScore(qf3, qfManager3, team6).execute();
new GoalScore(qf3, qfManager3, team6).execute();
new GoalScore(qf3, qfManager3, team5).execute();
new MatchEnd(qf3, qfManager3).execute();

// QF4 : Team Hotel 1 - 0 Team Golf
new GoalScore(qf4, qfManager4, team8).execute();
new MatchEnd(qf4, qfManager4).execute();

// === Création des feuilles ===
MatchLeaf leafQF1 = new MatchLeaf(qf1);
MatchLeaf leafQF2 = new MatchLeaf(qf2);
MatchLeaf leafQF3 = new MatchLeaf(qf3);
MatchLeaf leafQF4 = new MatchLeaf(qf4);

// === Demi-finales ===
Team semi1Team1 = (Team) leafQF1.execute();
Team semi1Team2 = (Team) leafQF2.execute();
Match sf1 = new Match(5, FOOTBALL, semi1Team1, semi1Team2, "02/06/2025", "SF Stadium 1");
FootballMatchManager sfManager1 = (FootballMatchManager) sf1.getMatchManager();

// Simulation SF1 : Team Alpha 1 - 0 Team Delta
new GoalScore(sf1, sfManager1, semi1Team1).execute();
new MatchEnd(sf1, sfManager1).execute();

Team semi2Team1 = (Team) leafQF3.execute();
Team semi2Team2 = (Team) leafQF4.execute();
Match sf2 = new Match(6, FOOTBALL, semi2Team1, semi2Team2, "02/06/2025", "SF Stadium 2");
FootballMatchManager sfManager2 = (FootballMatchManager) sf2.getMatchManager();

// Simulation SF2 : Team Echo 2 - 1 Team Hotel
new GoalScore(sf2, sfManager2, semi2Team1).execute();
new GoalScore(sf2, sfManager2, semi2Team2).execute();
new GoalScore(sf2, sfManager2, semi2Team1).execute();
new MatchEnd(sf2, sfManager2).execute();

// === Feuilles demi-finales ===
MatchLeaf leafSF1 = new MatchLeaf(sf1);
MatchLeaf leafSF2 = new MatchLeaf(sf2);

// === Finale ===
Team finalTeam1 = (Team) leafSF1.execute();
Team finalTeam2 = (Team) leafSF2.execute();
Match finalMatch = new Match(7, FOOTBALL, finalTeam1, finalTeam2, "03/06/2025", "Final Arena");
FootballMatchManager finalManager = (FootballMatchManager) finalMatch.getMatchManager();

// Simulation finale : Team Alpha 3 - 1 Team Echo
new GoalScore(finalMatch, finalManager, finalTeam1).execute();
new GoalScore(finalMatch, finalManager, finalTeam1).execute();
new GoalScore(finalMatch, finalManager, finalTeam2).execute();
new GoalScore(finalMatch, finalManager, finalTeam1).execute();
new MatchEnd(finalMatch, finalManager).execute();

// === Affichage des résultats ===
System.out.println("\n=== WINNER ===");
System.out.println("Winner: " + finalMatch.getMatchManager().getWinner().getFullname());

System.out.println("\n=== FINAL MATCH LOG ===");
finalMatch.getEventLog().forEach(System.out::println);

    }
}
