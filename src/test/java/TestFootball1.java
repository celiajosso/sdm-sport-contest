// simulate a big groupPhase (league)

import org.example.GroupStage;
import org.example.Sport;
import org.example.Tournament;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.util.*;

public class TestFootball1 {

    public static void main(String[] args) {
        List<Team> teams = FootballTeamDataLoader.loadTeams("FootballTeam.json");
        List<Contestant> contestants = new ArrayList<>(teams);

        Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
        GroupStage[] groupStage = footballTournament.createGroupStage(contestants.size(), true);

        System.out.println(groupStage.length + " group stages created.");
    }

}
