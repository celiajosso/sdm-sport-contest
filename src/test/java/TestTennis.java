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
    }
}
