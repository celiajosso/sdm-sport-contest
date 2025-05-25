package org.example;

import org.example.Sport;
import org.example.contestant.Player;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;

import java.util.ArrayList;
import java.util.List;

import static org.example.Sport.FOOTBALL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TeamMember player1 = new TeamMember("A","A","A","01/01/2001", "A");
        TeamMember player2 = new TeamMember("B","B","B","01/01/2001", "G");
        TeamMember player3 = new TeamMember("C","C","C","01/01/2001", "G");
        TeamMember player4 = new TeamMember("D","D","D","01/01/2001", "A");


        Team team1 = new Team("A", player1, new TeamMember[]{player1, player2});
        Team team2 = new Team("B", player3, new TeamMember[]{player3, player4});

        Match match1 = new Match(1, FOOTBALL,team1,team2,"25/05/2025","Poznan");

        Tournament footaballTournament = new Tournament(FOOTBALL, List.of(new Team[]{team1, team2}), List.of(new Match[]{match1}));
    }
}