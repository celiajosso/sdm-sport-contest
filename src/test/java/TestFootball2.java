// simulate a big tournament (groupPhase + knockout)

import org.example.GroupStage;
import org.example.SingleEliminationKnockout;
import org.example.Sport;
import org.example.Tournament;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestFootball2 {

        public static void main(String[] args) throws Exception {
                Path jsonPath = Paths.get(Objects.requireNonNull(TestFootball2.class.getResource("/FootballTeam.json")).toURI());
                List<Team> teams = FootballTeamDataLoader.loadTeams(jsonPath.toString());
                List<Contestant> contestants = new ArrayList<>(teams);

                Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
                GroupStage[] groupStage = footballTournament.createGroupStage(2, true);
                int[][] positionInTree = {
                        { 0, 3 },
                        { 2, 1 }
                };
                SingleEliminationKnockout knockout = footballTournament.createKnockout(positionInTree);

                System.out.println("\n=== List of matches for Group Stage");
                for (int i = 0; i < groupStage.length; i++) {
                        System.out.println("Group number " + (i + 1));
                        groupStage[i].displayPhase();
                }

                SimulatedMatches simulatedMatches = new SimulatedMatches();
                simulatedMatches.match1(groupStage, 0, 0);
                simulatedMatches.match2(groupStage, 0, 1);
                simulatedMatches.match3(groupStage, 1, 0);
                simulatedMatches.match4(groupStage, 1, 1);

                for (GroupStage gp : groupStage) {
                        gp.displayRanking();
                }
                
                System.out.println("=== List of matches for Single Elimination Knockout");

                knockout.displayPhase();

                // events for matches in single elimination knockout

        }
}
