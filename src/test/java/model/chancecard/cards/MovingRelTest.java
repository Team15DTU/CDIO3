package model.chancecard.cards;

import model.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovingRelTest {

    @Test
    public void action() {
        MovingRel movingRel = new MovingRel(1,"Does It move","If it move the test is complete",4);
        Player player = new Player("jens",100,1);
        movingRel.action(player);

        assertEquals(5,player.getPosition());
    }
}