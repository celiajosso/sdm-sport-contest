// simulate a big groupPhase (league)

import org.example.GroupStage;
import org.example.Sport;
import org.example.Tournament;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestFootball1 {

    public static void main(String[] args) throws Exception {
        Path jsonPath = Paths.get(TestFootball1.class.getResource("/FootballTeam.json").toURI());
        List<Team> teams = FootballTeamDataLoader.loadTeams(jsonPath.toString());
        List<Contestant> contestants = new ArrayList<>(teams);

        Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
        GroupStage[] groupStage = footballTournament.createGroupStage(contestants.size(), true);

        System.out.println(groupStage.length + " group stages created.");
    }

}
