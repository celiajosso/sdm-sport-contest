// simulate a big tournament (groupPhase + knockout)

import org.example.GroupStage;
import org.example.SingleEliminationKnockout;
import org.example.Sport;
import org.example.Tournament;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Player;
import org.example.contestant.Team;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestFootball2 {

        public static void main(String[] args) throws Exception {
                Path jsonPath = Paths.get(
                                Objects.requireNonNull(TestFootball2.class.getResource("/FootballTeam.json")).toURI());
                List<Team> teams = FootballTeamDataLoader.loadTeams(jsonPath.toString());
                List<Contestant> contestants = new ArrayList<>(teams);

                Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
                GroupStage[] groupStage = footballTournament.createGroupStage(2, true);
                int[][] positionInTree = {
                                { 0, 3 },
                                { 2, 1 }
                };
                SingleEliminationKnockout knockout = footballTournament.createKnockout(positionInTree);

                System.out.println("\nGROUP STAGE\n");
                for (int i = 0; i < groupStage.length; i++) {
                        System.out.println("   Group number " + (i + 1));
                        groupStage[i].displayPhase();
                }

                SimulatedMatches.match1(groupStage[0].getMatches()[0]);
                SimulatedMatches.match6(groupStage[0].getMatches()[1]);
                SimulatedMatches.match1(groupStage[1].getMatches()[0]);
                SimulatedMatches.match6(groupStage[1].getMatches()[1]);

                for (GroupStage gp : groupStage) {
                        gp.displayRanking();
                }

                System.out.println("\nSINGLE ELIMINATION KNOCKOUT\n");

                knockout.displayPhase();

                // events for matches in single elimination knockout

                knockout.getMatchesAtDepth(1).forEach(match -> {
                        Contestant playerA = match.getContestantA();
                        Contestant playerB = match.getContestantB();
                        System.out.println("Match: " + playerA.getFullname() + " vs " + playerB.getFullname());
                        SimulatedMatches.match2(match);
                });
                knockout.displayPhase();
                knockout.getMatchesAtDepth(0).forEach(match -> {
                        Contestant playerA = match.getContestantA();
                        Contestant playerB = match.getContestantB();
                        System.out.println("Match: " + playerA.getFullname() + " vs " + playerB.getFullname());
                        SimulatedMatches.match2(match);
                });
                knockout.displayPhase();
        }
}
