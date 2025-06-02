// simulate a big tournament (groupPhase + knockout)

import java.util.ArrayList;
import java.util.List;

import org.example.GroupStage;
import org.example.SingleEliminationKnockout;
import org.example.Sport;
import org.example.Tournament;
import org.example.contestant.Contestant;
import org.example.contestant.Team;

public class TestFootball2 {
    List<Team> teams = FootballTeamDataLoader.loadTeams("FootballTeam.json");
    List<Contestant> contestants = new ArrayList<>(teams);

    Tournament footballTournament = new Tournament(Sport.FOOTBALL, contestants);
    GroupStage[] groupStage = footballTournament.createGroupStage(2, true);

    int[][] positionInTree = {
            { 0, 2, 7, 5 },
            { 4, 6, 3, 1 }
    };

    SingleEliminationKnockout knockout = footballTournament.createKnockout(positionInTree); // ici param mais pas pour
                                                                                            // tennis et volley
}
