package model.chancecard.cards;

import model.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovingAbsTest {

    @Test
    public void action() {

        //Move to a position above
        MovingAbs movingAbs = new MovingAbs(1,"This field is on spot 13","and player land on 21",21);
        Player player = new Player("jens", 100, 13);
        movingAbs.action(player);
        assertEquals(21,player.getPosition());

        //Move to a position below
        MovingAbs movingAbs1 = new MovingAbs(2,"now you on 21, and get to 7","lets try",7);
        movingAbs1.action(player);
        assertEquals(7,player.getPosition());
    }
}