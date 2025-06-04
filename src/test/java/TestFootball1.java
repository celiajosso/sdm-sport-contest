// simulate a big groupPhase (league)

import org.example.GroupStage;
import org.example.Sport;
import org.example.Tournament;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestFootball1 {

    public static void main(String[] args) throws Exception {
        Path jsonPath = Paths.get(TestFootball1.class.getResource("/FootballTeam.json").toURI());
        List<Team> teams = FootballTeamDataLoader.loadTeams(jsonPath.toString());
        List<Contestant> contestants = new ArrayList<>(teams);

        Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
        GroupStage[] groupStage = footballTournament.createGroupStage(contestants.size(), false);

        System.out.println("\n=== List of matches for Group Stage");
        for (int i = 0; i < groupStage.length; i++) {
            System.out.println("Group number " + (i + 1));
            groupStage[i].displayPhase();
        }

        SimulatedMatches simulatedMatches = new SimulatedMatches();
        simulatedMatches.match1(groupStage, 0, 0);
        simulatedMatches.match2(groupStage, 0, 1);
        simulatedMatches.match3(groupStage, 0, 2);
        simulatedMatches.match4(groupStage, 0, 3);
        simulatedMatches.match5(groupStage, 0, 4);
        simulatedMatches.match6(groupStage, 0, 5);

        groupStage[0].displayRanking();
    }
}
