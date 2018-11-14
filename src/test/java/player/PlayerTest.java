package player;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Rasmus Sander Larsen
 * @date 07-11-2018
 */
public class PlayerTest {

    @Test
    public void updateScore() {
        // Variables
        final int STARTINGSCORE = 1000, EXTRAPOINT = 500;

        Player player1 = new Player("test",STARTINGSCORE);
        player1.updateScore(EXTRAPOINT);

        assertEquals( STARTINGSCORE+EXTRAPOINT, player1.getAccount().getBalance() );

    }

    @Test
    public void resetScore() {
        // Variables
        final int STARTINGSCORE = 1000;

        Player player1 = new Player("test",STARTINGSCORE);
        player1.resetScore();

        assertEquals( 0, player1.getAccount().getBalance() );
    }

    @Test
    public void getAccount() {
        // Variables
        final int STARTINGSCORE = 1000;

        Player player1 = new Player("test", STARTINGSCORE);

        Account acc = new Account();
        player1.setAccount(acc);

        assertEquals( acc, player1.getAccount() );

    }

    @Test
    public void setAccount() {
        // Create player object
        Player player1 = new Player("test");

        Account acc = new Account();
        player1.setAccount(acc);

        assertEquals( acc, player1.getAccount() );
    }

    @Test
    public void getName() {
        // Variables
        final int STARTINGSCORE = 1000;
        final String NAME       = "test";

        Player player1 = new Player( NAME, STARTINGSCORE );
        assertEquals( NAME, player1.getName() );

    }

    @Test
    public void setName() {
        // Variables
        final int STARTINGSCORE     = 1000;
        final String NAME           = "test";
        final String SETTEDNAME     = "Setted name";

        Player player1 = new Player( NAME, STARTINGSCORE );

        player1.setName(SETTEDNAME);

    }

    @Test
    public void isHasWon() {
        // Variables
        final int STARTINGSCORE = 9999;
        final String NAME       = "test";

        Player player1 = new Player( NAME, STARTINGSCORE );

        assertFalse( player1.isHasWon() );

    }

    @Test
    public void setHasWon() {

        final int STARTINGSCORE = 1000;
        final String name       = "test";

        Player player1 = new Player( name, STARTINGSCORE );
        assertFalse( player1.isHasWon() );

        player1.setHasWon(true);
        assertTrue( player1.isHasWon() );
    }
    
}