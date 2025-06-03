// simulate a big groupPhase (league)

import org.example.GroupStage;
import org.example.Sport;
import org.example.Tournament;
import org.example.Events.Football.GoalScore;

import org.example.Events.Football.MatchEnd;
import org.example.Events.Football.MatchStart;
import org.example.MatchManager.FootballMatchManager;
import org.example.config.FootballTeamDataLoader;
import org.example.contestant.Contestant;
import org.example.contestant.Team;
import org.example.Match;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.example.Sport.FOOTBALL;

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
        Team t1a = (Team) m1.getTeamA();
        Team t1b = (Team) m1.getTeamB();
        FootballMatchManager manager1 = new FootballMatchManager(m1);
        System.out.println("\n");
        new MatchStart(m1).execute();

        System.out.println("\n=== Events");
        new GoalScore(m1, manager1, t1a).execute();
        new GoalScore(m1, manager1, t1b).execute();
        new GoalScore(m1, manager1, t1a).execute();
        new GoalScore(m1, manager1, t1b).execute();

        new MatchEnd(m1, manager1).execute();
    }
}
