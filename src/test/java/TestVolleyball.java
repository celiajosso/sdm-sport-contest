import java.util.*;
import org.example.*;
import org.example.MatchManager.VolleyballMatchManager;
import org.example.contestant.Contestant;
import org.example.contestant.Team;
import org.example.contestant.TeamMember;
import org.example.Events.Volleyball.*;

public class TestVolleyball {

    public static void main(String[] args) throws Exception {
        List<Contestant> contestants = new ArrayList<>();
        contestants.add(createTeam("India", "Alice", "Bob"));
        contestants.add(createTeam("Juliet", "Clara", "Dan"));
        contestants.add(createTeam("Alpha", "Paula", "Daniela"));
        contestants.add(createTeam("Echo", "Sofia", "Julia"));
        contestants.add(createTeam("Bravo", "Liam", "Emma"));
        contestants.add(createTeam("Charlie", "Noah", "Ava"));
        contestants.add(createTeam("Delta", "Ethan", "Mia"));
        contestants.add(createTeam("Foxtrot", "Lucas", "Ella"));

        Tournament tournament = new Tournament(Sport.VOLLEYBALL, contestants);

        GroupStage[] groups = tournament.createGroupStage(4, false);

        for (int i = 0; i < groups.length; i++) {
            System.out.println("\n=== 🏐 MATCHS DE POULE - GROUPE " + (i + 1) + " ===");
            groups[i].displayPhase();

            for (Match match : groups[i].getMatches()) {
                simulateVolleyballMatch(match);
            }

            System.out.println("\n=== 🏆 CLASSEMENT - GROUPE " + (i + 1) + " ===");
            groups[i].displayRanking();
        }

        List<Contestant> qualifGroup1 = groups[0].getQualified(2);
        List<Contestant> qualifGroup2 = groups[1].getQualified(2);

        Team A1 = (Team) qualifGroup1.get(0);
        Team A2 = (Team) qualifGroup1.get(1);
        Team B1 = (Team) qualifGroup2.get(0);
        Team B2 = (Team) qualifGroup2.get(1);

        System.out.println("\n=== 🥈 DEMI-FINALES ===");
        Match semi1 = new Match(101, Sport.VOLLEYBALL, A1, B2, null, null);
        Match semi2 = new Match(102, Sport.VOLLEYBALL, B1, A2, null, null);

        Team winnerSemi1 = simulateVolleyballMatch(semi1);
        Team winnerSemi2 = simulateVolleyballMatch(semi2);

        System.out.println("\n=== 🏆 FINALE ===");
        Match finale = new Match(200, Sport.VOLLEYBALL, winnerSemi1, winnerSemi2, null, null);
        Team winner = simulateVolleyballMatch(finale);

        System.out.println("\n🎉 Vainqueur du tournoi : " + winner.getFullname());
    }

    public static Team simulateVolleyballMatch(Match match) {
        Random rand = new Random();
        VolleyballMatchManager manager = (VolleyballMatchManager) match.getMatchManager();
        Team teamA = (Team) match.getContestantA();
        Team teamB = (Team) match.getContestantB();

        System.out.println("\n🔹 Match : " + teamA.getFullname() + " vs " + teamB.getFullname());
        manager.applyVolleyBallEvent(new MatchStart(match));

        int setNumber = 1;
        while (match.getState() != MatchState.FINISHED) {
            manager.applyVolleyBallEvent(new SetStart(match, setNumber));

            Team winner = rand.nextBoolean() ? teamA : teamB;
            Team loser = (winner == teamA) ? teamB : teamA;

            int target = (setNumber == 5) ? 15 : 25;
            int loserScore = target - 2;

            for (int i = 0; i < target; i++) {
                manager.applyVolleyBallEvent(new PointScore(match, winner));
            }
            for (int i = 0; i < loserScore; i++) {
                manager.applyVolleyBallEvent(new PointScore(match, loser));
            }

            manager.applyVolleyBallEvent(new SetEnd(manager, setNumber, winner));
            setNumber++;
        }

        manager.applyVolleyBallEvent(new MatchEnd(match));
        Team winner = (Team) manager.getWinner();
        System.out.println("🏐 Match terminé. Vainqueur : " + winner.getFullname());
        return winner;
    }

    public static Team createTeam(String name, String player1, String player2) {
        TeamMember t1 = new TeamMember(player1, name, "01/01/2000", "FW");
        TeamMember t2 = new TeamMember(player2, name, "01/01/2000", "GK");
        return new Team(name, t1, new TeamMember[]{t1, t2});
    }
}
