// simulate a big groupPhase (league)

import org.example.contestant.Contestant;
import org.example.contestant.Team;

import java.util.*;

public class TestFootball1 {

    public static void main(String[] args) {

        // Load teams from JSON file
        List<Team> teams = FootballTeamDataLoader.loadTeams("FootballTeam.json");

        // Create teams
        Team france = teams.stream().filter(t -> t.getTeamName().equalsIgnoreCase("France")).findFirst().orElse(null);
        Team germany = teams.stream().filter(t -> t.getTeamName().equalsIgnoreCase("Germany")).findFirst().orElse(null);
        Team brazil = teams.stream().filter(t -> t.getTeamName().equalsIgnoreCase("Brazil")).findFirst().orElse(null);
        Team england = teams.stream().filter(t -> t.getTeamName().equalsIgnoreCase("England")).findFirst().orElse(null);
        List<Contestant> contestants = new ArrayList<>(teams);

        // Tournament footballTournament = new Tournament(...);

        // FootballMatchManager footballMatchManager = new
        // FootballMatchManager(matches);

        // do simulation events

    }

}
