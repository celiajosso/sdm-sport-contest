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
        groupStage.displayPhase();

        groupStage.getMatchesAtDepth(1).forEach(match -> {
            System.out.println("Match: " + match.getContestantA().getFullname() + " vs " + match.getContestantB().getFullname());

            // Récupération des joueurs
            Player playerA = (Player) match.getContestantA();
            Player playerB = (Player) match.getContestantB();
            var manager = match.getMatchManager();

            // Début du match
            manager.applyEvent(new org.example.Events.Tennis.MatchStart(match));
            // Premier set
            manager.applyEvent(new org.example.Events.Tennis.SetStart(match, 1));
            // Premier jeu
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            // Service joueur A
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerA));
            // Points du jeu 1
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            // Fin du jeu 1 (A gagne)
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerA));

            // Deuxième jeu
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            // Fin du jeu 2 (B gagne)
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerB));

            // Jeu 3 (A gagne)
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerA));

            // Jeu 4 (B gagne)
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerB));

            // Jeu 5 (A gagne)
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerA));

            // Jeu 6 (B gagne)
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerB));

            // Jeu 7 (A gagne le set)
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerA));
            // Fin du set 1
            manager.applyEvent(new org.example.Events.Tennis.SetEnd(match, 1, playerA, (org.example.MatchManager.TennisMatchManager) manager));

            // Second set (plus court)
            manager.applyEvent(new org.example.Events.Tennis.SetStart(match, 2));
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerB));
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerA));
            // Jeu décisif
            manager.applyEvent(new org.example.Events.Tennis.GameStart(match));
            manager.applyEvent(new org.example.Events.Tennis.WhoServe(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.GameEnd(match, (org.example.MatchManager.TennisMatchManager) manager, playerB));
            // Fin du set 2
            manager.applyEvent(new org.example.Events.Tennis.SetEnd(match, 2, playerB, (org.example.MatchManager.TennisMatchManager) manager));

            // Tie-break (exemple)
            manager.applyEvent(new org.example.Events.Tennis.TieBreak(match, 3));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerB));
            manager.applyEvent(new org.example.Events.Tennis.PointScore(match, playerA));
            // Fin du match
            manager.applyEvent(new org.example.Events.Tennis.MatchEnd(match));
        });
    }
}
