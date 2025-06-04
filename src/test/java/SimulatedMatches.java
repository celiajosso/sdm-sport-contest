import org.example.Match;
import org.example.MatchManager.FootballMatchManager;
import org.example.contestant.Team;
import org.example.GroupStage;

import org.example.Events.Football.*;

public class SimulatedMatches {
    public static void checkScore(FootballMatchManager manager, int expectedA, int expectedB) {
        int actualA = manager.getScoreA();
        int actualB = manager.getScoreB();
        if (actualA != expectedA || actualB != expectedB) {
            System.out.println(
                    "!!! Incorrect score for — Expected: " + expectedA + "-" + expectedB + ", Actual: " + actualA
                            + "-" + actualB + " !!!");
        }
    }

    public static void match1(Match match) {
        Match m1 = match;
        Team t1a = (Team) m1.getContestantA();
        Team t1b = (Team) m1.getContestantB();
        FootballMatchManager manager1 = (FootballMatchManager) m1.getMatchManager();
        System.out.println("\n");
        manager1.applyEvent(new MatchStart(m1));

        System.out.println("Events");
        manager1.applyEvent(new GoalScore(manager1, t1a.getTeamMembers()[1]));

        checkScore(manager1, 1, 0);
        manager1.applyEvent(new HalfTime(m1));
        manager1.applyEvent(new GoalScore(manager1, t1b.getTeamMembers()[3]));
        checkScore(manager1, 1, 1);
        manager1.applyEvent(new GoalScore(manager1, t1a.getTeamMembers()[6]));
        checkScore(manager1, 2, 1);
        manager1.applyEvent(new GoalScore(manager1, t1b.getTeamMembers()[8]));
        checkScore(manager1, 2, 2);
        manager1.applyEvent(new Offside(m1, t1a.getTeamMembers()[7]));
        manager1.applyEvent(new Corner(m1, t1b));
        manager1.applyEvent(new Freekick(m1, t1a));
        manager1.applyEvent(new MedicalBreak(m1, t1b.getTeamMembers()[10]));
        manager1.applyEvent(new RedCard(m1, t1a.getTeamMembers()[2]));
        manager1.applyEvent(new AdditionalTime(m1, 5));
        manager1.applyEvent(new GoalScore(manager1, t1b.getTeamMembers()[2]));
        checkScore(manager1, 2, 3);
        manager1.applyEvent(new GoalCancel(manager1, t1b));
        checkScore(manager1, 2, 2);
        manager1.applyEvent(new Overtime(m1, 30));
        manager1.applyEvent(new YellowCard(m1, t1a.getTeamMembers()[5]));
        manager1.applyEvent(new Substitution(manager1, t1a.getTeamMembers()[3], t1a.getTeamMembers()[9]));
        manager1.applyEvent(new GoalScore(manager1, t1a.getTeamMembers()[5]));
        checkScore(manager1, 3, 2);
        manager1.applyEvent(new Penalty(m1, t1b));
        manager1.applyEvent(new YellowCard(m1, t1a.getTeamMembers()[5]));
        manager1.applyEvent(new MatchEnd(manager1));
    }

    public static void match2(Match match) {
        Match m2 = match;
        Team t2a = (Team) m2.getContestantA();
        Team t2b = (Team) m2.getContestantB();
        FootballMatchManager manager2 = (FootballMatchManager) m2.getMatchManager();
        System.out.println("\n");
        manager2.applyEvent(new MatchStart(m2));

        System.out.println("Events");
        manager2.applyEvent(new GoalScore(manager2, t2a.getTeamMembers()[2]));
        checkScore(manager2, 1, 0);
        manager2.applyEvent(new Corner(m2, t2b));
        manager2.applyEvent(new YellowCard(m2, t2b.getTeamMembers()[1]));
        manager2.applyEvent(new Freekick(m2, t2a));
        manager2.applyEvent(new GoalScore(manager2, t2a.getTeamMembers()[6]));
        checkScore(manager2, 2, 0);
        manager2.applyEvent(new HalfTime(m2));
        manager2.applyEvent(new GoalScore(manager2, t2b.getTeamMembers()[1]));
        checkScore(manager2, 2, 1);
        manager2.applyEvent(new Offside(m2, t2b.getTeamMembers()[0]));
        manager2.applyEvent(new YellowCard(m2, t2a.getTeamMembers()[4]));
        manager2.applyEvent(new GoalCancel(manager2, t2a));
        checkScore(manager2, 1, 1);
        manager2.applyEvent(new MedicalBreak(m2, t2b.getTeamMembers()[5]));
        manager2.applyEvent(new Penalty(m2, t2a));
        manager2.applyEvent(new GoalScore(manager2, t2a.getTeamMembers()[8]));
        checkScore(manager2, 2, 1);
        manager2.applyEvent(new AdditionalTime(m2, 3));
        manager2.applyEvent(new MatchEnd(manager2));
    }

    public static void match3(Match match) {
        Match m3 = match;
        Team t3a = (Team) m3.getContestantA();
        Team t3b = (Team) m3.getContestantB();
        FootballMatchManager manager3 = (FootballMatchManager) m3.getMatchManager();
        System.out.println("\n");
        manager3.applyEvent(new MatchStart(m3));

        System.out.println("Events");
        manager3.applyEvent(new Freekick(m3, t3a));
        manager3.applyEvent(new Corner(m3, t3a));
        manager3.applyEvent(new GoalScore(manager3, t3b.getTeamMembers()[5]));
        checkScore(manager3, 0, 1);
        manager3.applyEvent(new YellowCard(m3, t3a.getTeamMembers()[0]));
        manager3.applyEvent(new GoalScore(manager3, t3a.getTeamMembers()[0]));
        checkScore(manager3, 1, 1);
        manager3.applyEvent(new GoalScore(manager3, t3a.getTeamMembers()[10]));
        checkScore(manager3, 2, 1);
        manager3.applyEvent(new HalfTime(m3));
        manager3.applyEvent(new RedCard(m3, t3b.getTeamMembers()[2]));
        manager3.applyEvent(new GoalScore(manager3, t3a.getTeamMembers()[9]));
        checkScore(manager3, 3, 1);
        manager3.applyEvent(new Substitution(manager3, t3a.getTeamMembers()[1],
                t3a.getTeamMembers()[10]));
        manager3.applyEvent(new MedicalBreak(m3, t3a.getTeamMembers()[3]));
        manager3.applyEvent(new Overtime(m3, 15));
        manager3.applyEvent(new GoalCancel(manager3, t3a));
        checkScore(manager3, 2, 1);
        manager3.applyEvent(new Offside(m3, t3b.getTeamMembers()[1]));
        manager3.applyEvent(new AdditionalTime(m3, 4));
        manager3.applyEvent(new MatchEnd(manager3));
    }

    public static void match4(Match match) {
        Match m4 = match;
        Team t4a = (Team) m4.getContestantA();
        Team t4b = (Team) m4.getContestantB();
        FootballMatchManager manager4 = (FootballMatchManager) m4.getMatchManager();
        System.out.println("\n");
        manager4.applyEvent(new MatchStart(m4));

        System.out.println("Events");
        manager4.applyEvent(new Corner(m4, t4b));
        manager4.applyEvent(new GoalScore(manager4, t4a.getTeamMembers()[8]));
        checkScore(manager4, 1, 0);
        manager4.applyEvent(new Freekick(m4, t4b));
        manager4.applyEvent(new Offside(m4, t4a.getTeamMembers()[10]));
        manager4.applyEvent(new HalfTime(m4));
        manager4.applyEvent(new GoalScore(manager4, t4b.getTeamMembers()[2]));
        checkScore(manager4, 1, 1);
        manager4.applyEvent(new YellowCard(m4, t4b.getTeamMembers()[3]));
        manager4.applyEvent(new RedCard(m4, t4a.getTeamMembers()[6]));
        manager4.applyEvent(new GoalScore(manager4, t4b.getTeamMembers()[3]));
        checkScore(manager4, 1, 2);
        manager4.applyEvent(new Substitution(manager4, t4b.getTeamMembers()[2],
                t4b.getTeamMembers()[7]));
        manager4.applyEvent(new MedicalBreak(m4, t4a.getTeamMembers()[4]));
        manager4.applyEvent(new GoalCancel(manager4, t4b));
        checkScore(manager4, 1, 1);
        manager4.applyEvent(new AdditionalTime(m4, 2));
        manager4.applyEvent(new Penalty(m4, t4a));
        manager4.applyEvent(new GoalScore(manager4, t4a.getTeamMembers()[0]));
        checkScore(manager4, 2, 1);
        manager4.applyEvent(new MatchEnd(manager4));
    }

    public static void match5(Match match) {
        Match m5 = match;
        Team t5a = (Team) m5.getContestantA();
        Team t5b = (Team) m5.getContestantB();
        FootballMatchManager manager5 = (FootballMatchManager) m5.getMatchManager();
        System.out.println("\n");
        manager5.applyEvent(new MatchStart(m5));

        System.out.println("Events");
        manager5.applyEvent(new GoalScore(manager5, t5b.getTeamMembers()[8]));
        checkScore(manager5, 0, 1);
        manager5.applyEvent(new GoalScore(manager5, t5a.getTeamMembers()[5]));
        checkScore(manager5, 1, 1);
        manager5.applyEvent(new HalfTime(m5));
        manager5.applyEvent(new Offside(m5, t5b.getTeamMembers()[2]));
        manager5.applyEvent(new RedCard(m5, t5a.getTeamMembers()[2]));
        manager5.applyEvent(new YellowCard(m5, t5b.getTeamMembers()[8]));
        manager5.applyEvent(new Freekick(m5, t5a));
        manager5.applyEvent(new Substitution(manager5, t5a.getTeamMembers()[0],
                t5a.getTeamMembers()[10]));
        manager5.applyEvent(new GoalCancel(manager5, t5a));
        checkScore(manager5, 0, 1);
        manager5.applyEvent(new GoalScore(manager5, t5b.getTeamMembers()[7]));
        checkScore(manager5, 0, 2);
        manager5.applyEvent(new AdditionalTime(m5, 6));
        manager5.applyEvent(new MatchEnd(manager5));
    }

    public static void match6(Match match) {
        Match m6 = match;
        Team t6a = (Team) m6.getContestantA();
        Team t6b = (Team) m6.getContestantB();
        FootballMatchManager manager6 = (FootballMatchManager) m6.getMatchManager();
        System.out.println("\n");
        manager6.applyEvent(new MatchStart(m6));

        System.out.println("Events");
        manager6.applyEvent(new Freekick(m6, t6b));
        manager6.applyEvent(new GoalScore(manager6, t6a.getTeamMembers()[6]));
        checkScore(manager6, 1, 0);
        manager6.applyEvent(new Offside(m6, t6a.getTeamMembers()[9]));
        manager6.applyEvent(new YellowCard(m6, t6a.getTeamMembers()[1]));
        manager6.applyEvent(new GoalScore(manager6, t6a.getTeamMembers()[2]));
        checkScore(manager6, 2, 0);
        manager6.applyEvent(new HalfTime(m6));
        manager6.applyEvent(new GoalScore(manager6, t6b.getTeamMembers()[1]));
        checkScore(manager6, 2, 1);
        manager6.applyEvent(new Corner(m6, t6b));
        manager6.applyEvent(new RedCard(m6, t6b.getTeamMembers()[4]));
        manager6.applyEvent(new Substitution(manager6, t6b.getTeamMembers()[6],
                t6b.getTeamMembers()[5]));
        manager6.applyEvent(new Penalty(m6, t6b));
        manager6.applyEvent(new GoalScore(manager6, t6b.getTeamMembers()[10]));
        checkScore(manager6, 2, 2);
        manager6.applyEvent(new Overtime(m6, 10));
        manager6.applyEvent(new AdditionalTime(m6, 2));
        manager6.applyEvent(new MatchEnd(manager6));
    }
}
