package player;

import model.player.Account;
import model.player.Player;
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
    public void updatePosition() {

        /*
        First check where it shouldn't wrap around
         */

        // Variables
        final int STARTPOSITION1 = 1, FIELDSTOMOVE1 = 10, EXPECTED1 = STARTPOSITION1+FIELDSTOMOVE1;

        // Create player and set startposition
        Player player1 = new Player("A", 200, STARTPOSITION1);

        // Call the update method
        player1.updatePosition(FIELDSTOMOVE1);

        // Check if it's correct
        assertEquals(EXPECTED1, player1.getPosition());

        /*
        --------------------------------------------------------
        Second check where it SHOULD wrap around
         */

        // Variables
        final int STARTPOSITION2 = 20, FIELDSTOMOVE2 = 10, EXPECTED2 = (STARTPOSITION2+FIELDSTOMOVE2) % 24;

        // Create player and set startposition
        Player player2 = new Player("B", 200, STARTPOSITION2);

        // Call the update method
        player2.updatePosition(FIELDSTOMOVE2);

        // Check if it's correct
        assertEquals(EXPECTED2, player2.getPosition());
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

}