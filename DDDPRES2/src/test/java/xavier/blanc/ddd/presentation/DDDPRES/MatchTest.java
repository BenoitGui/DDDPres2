package xavier.blanc.ddd.presentation.DDDPRES;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MatchTest {

    @SuppressWarnings("deprecation")
	@Test
    public void contructorTest() {
        Player winner = new Player("winner");
        Player loser = new Player("loser");
        Match m = new Match(winner, loser,1);
        assertEquals(new Player[]{winner, loser}, m.TwoPlayers());
        Match m2 = new Match(loser, winner,2);
        assertEquals(new Player[]{loser, winner}, m2.TwoPlayers());
        assertNotEquals(m, m2);
        assertEquals(false, m.isStarted());
        assertEquals(false, m.isClosed());
        try {
            m.Winner();
            fail();
        } catch (ChampionshipException ex) {

        }
        try {
            m.updateScorePlayer1(0);
            fail();
        } catch (ChampionshipException ex) {

        }
    }

    @Test
    public void startedTest() {
        Player winner = new Player("winner");
        Player loser = new Player("loser");
        Match m = new Match(winner, loser, 1);
        m.start();
        assertEquals(true, m.isStarted());
        m.updateScorePlayer1(2);
        m.updateScorePlayer2(0);
    }

    @Test
    public void closedTest() {
        Player winner = new Player("winner");
        Player loser = new Player("loser");
        Match m = new Match(winner, loser, 1);
        m.start();
        m.updateScorePlayer1(2);
        m.updateScorePlayer2(0);
        m.close();
        assertEquals(true, m.isClosed());
        assertEquals(false, m.isDraw());
        assertEquals(winner, m.Winner());
        try {
            m.start();
            fail();
        } catch (ChampionshipException ex) {

        }
        try {
            m.updateScorePlayer1(5);
            fail();
        } catch (ChampionshipException ex) {
            
        }
    }
}