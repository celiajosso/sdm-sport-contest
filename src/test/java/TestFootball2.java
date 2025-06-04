// simulate a big tournament (groupPhase + knockout)

import org.example.GroupStage;
import org.example.Match;
import org.example.SingleEliminationKnockout;
import org.example.Sport;
import org.example.Tournament;
import org.example.Events.Football.*;
import org.example.MatchManager.FootballMatchManager;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestFootball2 {

        public static void checkScore(FootballMatchManager manager, int expectedA, int expectedB) {
                int actualA = manager.getScoreA();
                int actualB = manager.getScoreB();
                if (actualA != expectedA || actualB != expectedB) {
                        System.out.println(
                                        "!!! Incorrect score for — Expected: " + expectedA + "-" + expectedB
                                                        + ", Actual: " + actualA
                                                        + "-" + actualB + " !!!");
                }
        }

        public static void main(String[] args) throws Exception {
                Path jsonPath = Paths.get(TestFootball2.class.getResource("/FootballTeam.json").toURI());
                List<Team> teams = FootballTeamDataLoader.loadTeams(jsonPath.toString());
                List<Contestant> contestants = new ArrayList<>(teams);

                Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
                GroupStage[] groupStage = footballTournament.createGroupStage(2, true);

                System.out.println("\n=== List of matches for Group Stage");
                for (int i = 0; i < groupStage.length; i++) {
                        System.out.println("Group number " + (i + 1));
                        groupStage[i].displayPhase();
                }

                // match 1
                Match m1 = groupStage[0].getMatches()[0];
                Team t1a = (Team) m1.getContestantA();
                Team t1b = (Team) m1.getContestantB();
                FootballMatchManager manager1 = new FootballMatchManager(m1);
                System.out.println("\n");
                new MatchStart(m1).execute();

                System.out.println("\n=== Events");
                new GoalScore(manager1, t1a.getTeamMembers()[1]).execute();
                checkScore(manager1, 1, 0);
                new HalfTime(m1).execute();
                new GoalScore(manager1, t1b.getTeamMembers()[3]).execute();
                checkScore(manager1, 1, 1);
                new GoalScore(manager1, t1a.getTeamMembers()[6]).execute();
                checkScore(manager1, 2, 1);
                new GoalScore(manager1, t1b.getTeamMembers()[8]).execute();
                checkScore(manager1, 2, 2);
                new Offside(m1, t1a.getTeamMembers()[7]).execute();
                new Corner(m1, t1b).execute();
                new Freekick(m1, t1a).execute();
                new MedicalBreak(m1, t1b.getTeamMembers()[10]).execute();
                new RedCard(m1, t1a.getTeamMembers()[2]).execute();
                new AdditionalTime(m1, 5).execute();
                new GoalScore(manager1, t1b.getTeamMembers()[2]).execute();
                checkScore(manager1, 2, 3);
                new GoalCancel(manager1, t1b).execute();
                checkScore(manager1, 2, 2);
                new Overtime(m1, 30).execute();
                new YellowCard(m1, t1a.getTeamMembers()[5]).execute();
                new Substitution(manager1, t1a.getTeamMembers()[3], t1a.getTeamMembers()[9]).execute();
                new GoalScore(manager1, t1a.getTeamMembers()[5]).execute();
                checkScore(manager1, 3, 2);
                new Penalty(m1, t1b).execute();
                new YellowCard(m1, t1a.getTeamMembers()[5]).execute();
                new MatchEnd(manager1).execute();

                // Match 2
                Match m2 = groupStage[0].getMatches()[1];
                Team t2a = (Team) m2.getContestantA();
                Team t2b = (Team) m2.getContestantB();
                FootballMatchManager manager2 = new FootballMatchManager(m2);
                System.out.println("\n");
                new MatchStart(m2).execute();

                System.out.println("\n=== Events");
                new GoalScore(manager2, t2a.getTeamMembers()[2]).execute();
                checkScore(manager2, 1, 0);
                new Corner(m2, t2b).execute();
                new YellowCard(m2, t2b.getTeamMembers()[1]).execute();
                new Freekick(m2, t2a).execute();
                new GoalScore(manager2, t2a.getTeamMembers()[6]).execute();
                checkScore(manager2, 2, 0);
                new HalfTime(m2).execute();
                new GoalScore(manager2, t2b.getTeamMembers()[1]).execute();
                checkScore(manager2, 2, 1);
                new Offside(m2, t2b.getTeamMembers()[0]).execute();
                new YellowCard(m2, t2a.getTeamMembers()[4]).execute();
                new GoalCancel(manager2, t2a).execute();
                checkScore(manager2, 1, 1);
                new MedicalBreak(m2, t2b.getTeamMembers()[5]).execute();
                new Penalty(m2, t2a).execute();
                new GoalScore(manager2, t2a.getTeamMembers()[8]).execute();
                checkScore(manager2, 2, 1);
                new AdditionalTime(m2, 3).execute();
                new MatchEnd(manager2).execute();

                // Match 3
                Match m3 = groupStage[1].getMatches()[0];
                Team t3a = (Team) m3.getContestantA();
                Team t3b = (Team) m3.getContestantB();
                FootballMatchManager manager3 = new FootballMatchManager(m3);
                System.out.println("\n");
                new MatchStart(m3).execute();

                System.out.println("\n=== Events");
                new Freekick(m3, t3a).execute();
                new Corner(m3, t3a).execute();
                new GoalScore(manager3, t3b.getTeamMembers()[5]).execute();
                checkScore(manager3, 0, 1);
                new YellowCard(m3, t3a.getTeamMembers()[0]).execute();
                new GoalScore(manager3, t3a.getTeamMembers()[0]).execute();
                checkScore(manager3, 1, 1);
                new GoalScore(manager3, t3a.getTeamMembers()[10]).execute();
                checkScore(manager3, 2, 1);
                new HalfTime(m3).execute();
                new RedCard(m3, t3b.getTeamMembers()[2]).execute();
                new GoalScore(manager3, t3a.getTeamMembers()[9]).execute();
                checkScore(manager3, 3, 1);
                new Substitution(manager3, t3a.getTeamMembers()[1], t3a.getTeamMembers()[10]).execute();
                new MedicalBreak(m3, t3a.getTeamMembers()[3]).execute();
                new Overtime(m3, 15).execute();
                new GoalCancel(manager3, t3a).execute();
                checkScore(manager3, 2, 1);
                new Offside(m3, t3b.getTeamMembers()[1]).execute();
                new AdditionalTime(m3, 4).execute();
                new MatchEnd(manager3).execute();

                // Match 4
                Match m4 = groupStage[1].getMatches()[1];
                Team t4a = (Team) m4.getContestantA();
                Team t4b = (Team) m4.getContestantB();
                FootballMatchManager manager4 = new FootballMatchManager(m4);
                System.out.println("\n");
                new MatchStart(m4).execute();

                System.out.println("\n=== Events Match 4");
                new Corner(m4, t4b).execute();
                new GoalScore(manager4, t4a.getTeamMembers()[8]).execute();
                checkScore(manager4, 1, 0);
                new Freekick(m4, t4b).execute();
                new Offside(m4, t4a.getTeamMembers()[10]).execute();
                new HalfTime(m4).execute();
                new GoalScore(manager4, t4b.getTeamMembers()[2]).execute();
                checkScore(manager4, 1, 1);
                new YellowCard(m4, t4b.getTeamMembers()[3]).execute();
                new RedCard(m4, t4a.getTeamMembers()[6]).execute();
                new GoalScore(manager4, t4b.getTeamMembers()[3]).execute();
                checkScore(manager4, 1, 2);
                new Substitution(manager4, t4b.getTeamMembers()[2], t4b.getTeamMembers()[7]).execute();
                new MedicalBreak(m4, t4a.getTeamMembers()[4]).execute();
                new GoalCancel(manager4, t4b).execute();
                checkScore(manager4, 1, 1);
                new AdditionalTime(m4, 2).execute();
                new Penalty(m4, t4a).execute();
                new GoalScore(manager4, t4a.getTeamMembers()[0]).execute();
                checkScore(manager4, 2, 1);
                new MatchEnd(manager4).execute();

                for (GroupStage gp : groupStage) {
                        gp.getRanking();
                }

                int[][] positionInTree = {
                                { 0, 3 },
                                { 2, 1 }
                };

                SingleEliminationKnockout knockout = footballTournament.createKnockout(positionInTree);
                System.out.println("=== List of matches for Single Elimination Knockout");
                knockout.displayPhase();

                // events for matches in single elimination knockout

        }
}
