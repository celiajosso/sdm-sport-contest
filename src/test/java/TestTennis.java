import org.example.SingleEliminationKnockout;
import org.example.Sport;
import org.example.Tournament;
import org.example.contestant.Contestant;
import org.example.contestant.Player;

import java.util.ArrayList;
import java.util.List;

// just knockout in tennis
public class TestTennis {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player("Roger", "Federer", "08/08/1981");
        Player player2 = new Player("Rafael", "Nadal", "03/06/1986");
        Player player3 = new Player("Novak", "Djokovic", "22/05/1987");
        Player player4 = new Player("Andy", "Murray", "15/05/1987");

        List<Contestant> contestants = new ArrayList<>();

        contestants.add(player1);
        contestants.add(player2);
        contestants.add(player3);
        contestants.add(player4);

        Tournament tennisTournament = new Tournament(Sport.TENNIS, contestants);
        SingleEliminationKnockout groupStage = tennisTournament.createKnockout();

        groupStage.getMatchesAtDepth(1).forEach(match -> {

            Contestant playerA = match.getContestantA();
            Contestant playerB = match.getContestantB();
            System.out.println("Match: " + playerA.getFullname() + " vs " + playerB.getFullname());
            var manager = match.getMatchManager();

            manager.applyEvent(new org.example.Events.Tennis.MatchStart(match));
            int[][][] allJeux = new int[][][] {
                    { { 1, 0 }, { 0, 1 }, { 1, 0 }, { 1, 0 }, { 1, 0 } },
                    { { 0, 1 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 } },
                    { { 1, 0 }, { 1, 0 }, { 0, 1 }, { 1, 0 }, { 1, 0 } }
            };

            int set = 0;

            for (int[][] jeux : allJeux) {
                set++;
                manager.applyEvent(new org.example.Events.Tennis.SetStart(match, set));

                for (int jeu = 0; jeu < jeux.length; jeu++) {
                    Player serveur = (jeu % 2 == 0) ? (Player) playerA : (Player) playerB;
                    manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
                    manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, serveur));

                    Player winner = (jeux[jeu][0] == 1) ? (Player) playerA : (Player) playerB;
                    for (int p = 0; p < 3; p++) {
                        manager.applyEvent(new org.example.Events.Tennis.PointScore(match, winner));
                    }
                    manager.applyEvent(new org.example.Events.Tennis.GameEnd(
                            (org.example.MatchManager.TennisMatchManager) manager, winner));
                }
                manager.applyEvent(new org.example.Events.Tennis.SetEnd(
                        (org.example.MatchManager.TennisMatchManager) manager, set, (Player) playerA));
            }
            manager.applyEvent(new org.example.Events.Tennis.MatchEnd(match));
        });

        groupStage.getMatchesAtDepth(0).forEach(match -> {
            Contestant playerA = match.getContestantA();
            Contestant playerB = match.getContestantB();
            System.out.println("Match: " + playerA.getFullname() + " vs " + playerB.getFullname());

            var manager = match.getMatchManager();

            manager.applyEvent(new org.example.Events.Tennis.MatchStart(match));
            int[][][] allJeux = new int[][][] {
                    { { 1, 0 }, { 0, 1 }, { 1, 0 }, { 1, 0 }, { 1, 0 } },
                    { { 0, 1 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 } },
                    { { 1, 0 }, { 1, 0 }, { 0, 1 }, { 1, 0 }, { 1, 0 } }
            };

            int set = 0;

            for (int[][] jeux : allJeux) {
                set++;
                manager.applyEvent(new org.example.Events.Tennis.SetStart(match, set));

                for (int jeu = 0; jeu < jeux.length; jeu++) {
                    Player serveur = (jeu % 2 == 0) ? (Player) playerA : (Player) playerB;
                    manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
                    manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, serveur));

                    Player winner = (jeux[jeu][0] == 1) ? (Player) playerA : (Player) playerB;
                    for (int p = 0; p < 3; p++) {
                        manager.applyEvent(new org.example.Events.Tennis.PointScore(match, winner));
                    }
                    manager.applyEvent(new org.example.Events.Tennis.GameEnd(
                            (org.example.MatchManager.TennisMatchManager) manager, winner));
                }
                manager.applyEvent(new org.example.Events.Tennis.SetEnd(
                        (org.example.MatchManager.TennisMatchManager) manager, set, (Player) playerA));
            }
            manager.applyEvent(new org.example.Events.Tennis.MatchEnd(match));
        });
        groupStage.displayPhase();

    }
}
