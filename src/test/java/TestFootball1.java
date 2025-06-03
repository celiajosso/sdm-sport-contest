// simulate a big groupPhase (league)

import org.example.GroupStage;
import org.example.Sport;
import org.example.Tournament;
import org.example.Events.Football.AdditionalTime;
import org.example.Events.Football.Corner;
import org.example.Events.Football.Freekick;
import org.example.Events.Football.GoalCancel;
import org.example.Events.Football.GoalScore;
import org.example.Events.Football.HalfTime;
import org.example.Events.Football.MatchEnd;
import org.example.Events.Football.MatchStart;
import org.example.Events.Football.Offside;
import org.example.Events.Football.Overtime;
import org.example.Events.Football.Penalty;
import org.example.Events.Football.RedCard;
import org.example.Events.Football.YellowCard;
import org.example.Events.Football.MedicalBreak;
import org.example.Events.Football.Substitution;
import org.example.MatchManager.FootballMatchManager;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;
import org.example.Match;

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

        // match 1
        Match m1 = groupStage[0].getMatches()[0];
        Team t1a = (Team) m1.getContestantA();
        Team t1b = (Team) m1.getContestantB();
        FootballMatchManager manager1 = new FootballMatchManager(m1);
        System.out.println("\n");
        new MatchStart(m1).execute();

        System.out.println("\n=== Events");
        new GoalScore(m1, manager1, t1a, t1a.getTeamMembers()[1]).execute();
        new HalfTime(m1).execute();
        new GoalScore(m1, manager1, t1b, t1b.getTeamMembers()[3]).execute();
        new GoalScore(m1, manager1, t1a, t1a.getTeamMembers()[6]).execute();
        new GoalScore(m1, manager1, t1b, t1b.getTeamMembers()[8]).execute();
        new Offside(m1, t1a, t1a.getTeamMembers()[7]).execute();
        new Corner(m1, t1b, t1b.getTeamMembers()[6]).execute();
        new Freekick(m1, t1a).execute();
        new MedicalBreak(m1, t1b, t1b.getTeamMembers()[10]).execute();
        new RedCard(m1, t1a.getTeamMembers()[2], t1a).execute();
        new AdditionalTime(m1, 5).execute();
        new GoalScore(m1, manager1, t1b, t1b.getTeamMembers()[2]).execute();
        new GoalCancel(m1, manager1, t1b).execute();
        new Overtime(m1, 30).execute();
        new YellowCard(m1, t1a.getTeamMembers()[5], t1a).execute();
        new Substitution(m1, t1b, t1a.getTeamMembers()[3], t1a.getTeamMembers()[9]).execute();
        new GoalScore(m1, manager1, t1a, t1a.getTeamMembers()[5]).execute();
        new Penalty(m1, t1b, t1b.getTeamMembers()[0]).execute();
        new YellowCard(m1, t1a.getTeamMembers()[5], t1a).execute();
        new MatchEnd(m1, manager1).execute();

        // Match 2
        Match m2 = groupStage[0].getMatches()[1];
        Team t2a = (Team) m2.getContestantA();
        Team t2b = (Team) m2.getContestantB();
        FootballMatchManager manager2 = new FootballMatchManager(m2);
        System.out.println("\n");
        new MatchStart(m2).execute();

        System.out.println("\n=== Events");
        new GoalScore(m2, manager2, t2a, t2a.getTeamMembers()[2]).execute();
        new Corner(m2, t2b, t2b.getTeamMembers()[6]).execute();
        new YellowCard(m2, t2b.getTeamMembers()[1], t2b).execute();
        new Freekick(m2, t2a).execute();
        new GoalScore(m2, manager2, t2a, t2a.getTeamMembers()[6]).execute();
        new HalfTime(m2).execute();
        new GoalScore(m2, manager2, t2b, t2b.getTeamMembers()[1]).execute();
        new Offside(m2, t2b, t2b.getTeamMembers()[0]).execute();
        new YellowCard(m2, t2a.getTeamMembers()[4], t2a).execute();
        new GoalCancel(m2, manager2, t2b).execute();
        new MedicalBreak(m2, t2b, t2b.getTeamMembers()[5]).execute();
        new Penalty(m2, t2a, t2a.getTeamMembers()[4]).execute();
        new GoalScore(m2, manager2, t2a, t2a.getTeamMembers()[8]).execute();
        new AdditionalTime(m2, 3).execute();
        new MatchEnd(m2, manager2).execute();

        // Match 3
        Match m3 = groupStage[0].getMatches()[2];
        Team t3a = (Team) m3.getContestantA();
        Team t3b = (Team) m3.getContestantB();
        FootballMatchManager manager3 = new FootballMatchManager(m3);
        System.out.println("\n");
        new MatchStart(m3).execute();

        System.out.println("\n=== Events");
        new Freekick(m3, t3a).execute();
        new Corner(m3, t3a, t3a.getTeamMembers()[5]).execute();
        new GoalScore(m3, manager3, t3b, t3b.getTeamMembers()[5]).execute();
        new YellowCard(m3, t3a.getTeamMembers()[0], t3a).execute();
        new GoalScore(m3, manager3, t3a, t3a.getTeamMembers()[0]).execute();
        new GoalScore(m3, manager3, t3a, t3a.getTeamMembers()[10]).execute();
        new HalfTime(m3).execute();
        new RedCard(m3, t3b.getTeamMembers()[2], t3b).execute();
        new GoalScore(m3, manager3, t3a, t3a.getTeamMembers()[9]).execute();
        new Substitution(m3, t3a, t3a.getTeamMembers()[1], t3a.getTeamMembers()[10]).execute();
        new MedicalBreak(m3, t3a, t3a.getTeamMembers()[3]).execute();
        new Overtime(m3, 15).execute();
        new GoalCancel(m3, manager3, t3a).execute();
        new Offside(m3, t3b, t3b.getTeamMembers()[1]).execute();
        new AdditionalTime(m3, 4).execute();
        new MatchEnd(m3, manager3).execute();

        // Match 4
        Match m4 = groupStage[0].getMatches()[3];
        Team t4a = (Team) m4.getContestantA();
        Team t4b = (Team) m4.getContestantB();
        FootballMatchManager manager4 = new FootballMatchManager(m4);
        System.out.println("\n");
        new MatchStart(m4).execute();

        System.out.println("\n=== Events Match 4");
        new Corner(m4, t4b, t4b.getTeamMembers()[7]).execute();
        new GoalScore(m4, manager4, t4a, t4a.getTeamMembers()[8]).execute();
        new Freekick(m4, t4b).execute();
        new Offside(m4, t4a, t4a.getTeamMembers()[10]).execute();
        new HalfTime(m4).execute();
        new GoalScore(m4, manager4, t4b, t4b.getTeamMembers()[2]).execute();
        new YellowCard(m4, t4b.getTeamMembers()[3], t4b).execute();
        new RedCard(m4, t4a.getTeamMembers()[6], t4b).execute();
        new GoalScore(m4, manager4, t4b, t4b.getTeamMembers()[3]).execute();
        new Substitution(m4, t4b, t4b.getTeamMembers()[2], t4b.getTeamMembers()[7]).execute();
        new MedicalBreak(m4, t4a, t4a.getTeamMembers()[4]).execute();
        new GoalCancel(m4, manager4, t4b).execute();
        new AdditionalTime(m4, 2).execute();
        new Penalty(m4, t4a, t4a.getTeamMembers()[0]).execute();
        new GoalScore(m4, manager4, t4a, t4a.getTeamMembers()[0]).execute();
        new MatchEnd(m4, manager4).execute();

        // Match 5
        Match m5 = groupStage[0].getMatches()[4];
        Team t5a = (Team) m5.getContestantA();
        Team t5b = (Team) m5.getContestantB();
        FootballMatchManager manager5 = new FootballMatchManager(m5);
        System.out.println("\n");
        new MatchStart(m5).execute();

        // Match 6
        System.out.println("\n=== Events");
        new GoalScore(m5, manager5, t5b, t5b.getTeamMembers()[8]).execute();
        new GoalScore(m5, manager5, t5a, t5a.getTeamMembers()[5]).execute();
        new HalfTime(m5).execute();
        new Offside(m5, t5b, t5b.getTeamMembers()[2]).execute();
        new RedCard(m5, t5a.getTeamMembers()[2], t5a).execute();
        new YellowCard(m5, t5b.getTeamMembers()[8], t5a).execute();
        new Freekick(m5, t5a).execute();
        new Substitution(m5, t5a, t5a.getTeamMembers()[0], t5a.getTeamMembers()[10]).execute();
        new GoalCancel(m5, manager5, t5a).execute();
        new GoalScore(m5, manager5, t5b, t5b.getTeamMembers()[7]).execute();
        new AdditionalTime(m5, 6).execute();
        new MatchEnd(m5, manager5).execute();

        Match m6 = groupStage[0].getMatches()[5];
        Team t6a = (Team) m6.getContestantA();
        Team t6b = (Team) m6.getContestantB();
        FootballMatchManager manager6 = new FootballMatchManager(m6);
        System.out.println("\n");
        new MatchStart(m6).execute();

        System.out.println("\n=== Events");
        new Freekick(m6, t6b).execute();
        new GoalScore(m6, manager6, t6a, t6a.getTeamMembers()[6]).execute();
        new Offside(m6, t6a, t6a.getTeamMembers()[9]).execute();
        new YellowCard(m6, t6a.getTeamMembers()[1], t6a).execute();
        new GoalScore(m6, manager6, t6a, t6a.getTeamMembers()[2]).execute();
        new HalfTime(m6).execute();
        new GoalScore(m6, manager6, t6b, t6b.getTeamMembers()[1]).execute();
        new Corner(m6, t6b, t6b.getTeamMembers()[7]).execute();
        new RedCard(m6, t6b.getTeamMembers()[4], t6b).execute();
        new Substitution(m6, t6b, t6b.getTeamMembers()[6], t6b.getTeamMembers()[5]).execute();
        new Penalty(m6, t6b, t6b.getTeamMembers()[3]).execute();
        new GoalScore(m6, manager6, t6b, t6b.getTeamMembers()[10]).execute();
        new Overtime(m6, 10).execute();
        new AdditionalTime(m6, 2).execute();
        new MatchEnd(m6, manager6).execute();

    }
}
