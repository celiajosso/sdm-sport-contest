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

        Match semiFinal1 = new Match(1, FOOTBALL, team1, team2, "01/06/2025", "Stadium A");
        Match semiFinal2 = new Match(2, FOOTBALL, team3, team4, "01/06/2025", "Stadium B");

        FootballMatchManager manager1 = new FootballMatchManager(semiFinal1);
        FootballMatchManager manager2 = new FootballMatchManager(semiFinal2);

        new GoalScore(semiFinal1, manager1, team1).execute();
        new GoalScore(semiFinal1, manager1, team1).execute();
        new GoalScore(semiFinal1, manager1, team2).execute();
        new MatchEnd(semiFinal1, manager1).execute();

        new GoalScore(semiFinal2, manager2, team3).execute();
        new GoalScore(semiFinal2, manager2, team4).execute();
        new GoalScore(semiFinal2, manager2, team3).execute();
        new MatchEnd(semiFinal2, manager2).execute();
        System.out.println("Finalistes : " + team1);

        MatchLeaf leaf1 = new MatchLeaf(semiFinal1);
        MatchLeaf leaf2 = new MatchLeaf(semiFinal2);
        System.out.println("Finalistes : " + leaf1 + " VS " + leaf2);

        MatchComposite finalComposite = new MatchComposite();
        finalComposite.add(leaf1);
        finalComposite.add(leaf2);
        System.out.println("€€€€€€€€€€€€€€€€€€€€€€€€€: " + finalComposite);

        finalComposite.execute();

        System.out.println("SemiFinal1 state: " + semiFinal1.getState());
        System.out.println("SemiFinal2 state: " + semiFinal2.getState());


        Team finalist1 = (Team) leaf1.execute();
        Team finalist2 = (Team) leaf2.execute();

        System.out.println("Match state leaf1: " + leaf1.getMatch().getState());
        System.out.println("Winner from manager leaf1: " + leaf1.getMatch().getMatchManager().getWinner());
        
        System.out.println("Finalistes : " + finalist1 + " VS " + finalist2);

        Match finalMatch = new Match(3, FOOTBALL, finalist1, finalist2, "02/06/2025", "Final Arena");
        FootballMatchManager finalManager = new FootballMatchManager(finalMatch);
        
        new GoalScore(finalMatch, finalManager, finalist1).execute();
        new GoalScore(finalMatch, finalManager, finalist1).execute();
        new MatchEnd(finalMatch, finalManager).execute();

        System.out.println("\n=== SEMI FINAL 1 LOG ===");
        semiFinal1.getEventLog().forEach(System.out::println);

        System.out.println("\n=== SEMI FINAL 2 LOG ===");
        semiFinal2.getEventLog().forEach(System.out::println);

        System.out.println("\n=== FINAL LOG ===");
        finalMatch.getEventLog().forEach(System.out::println);
    }
}
