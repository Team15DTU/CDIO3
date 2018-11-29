package model.player;

import model.board.fields.Property;
import org.junit.Test;

import java.awt.*;

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

        Player player2 = new Player("test","cat");
        player2.updateScore(EXTRAPOINT);

        assertEquals( 500, player2.getAccount().getBalance() );

        Player player3 = new Player("test",100,1);
        player3.updateScore(EXTRAPOINT);

        assertEquals( 600, player3.getAccount().getBalance() );


        Player player4 = new Player("test","cat",100,1);
        player4.updateScore(EXTRAPOINT);

        assertEquals( 600, player4.getAccount().getBalance() );


        Player player5 = new Player("test");
        player5.updateScore(EXTRAPOINT);

        assertEquals( 500, player5.getAccount().getBalance() );
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

    @Test
    public void updateTotalProoertyValue() {

        Player player = new Player("jens");
        Property prop = new Property(1,"haven","Druk paladset have",2, Color.red);
        player.getPropertyCost().add(prop.getCost());
        player.updateTotalPropertyValue();

        assertEquals(2, player.getTotalPropertyValue());

    }

}