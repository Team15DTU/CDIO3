package model.board.fields;

import model.board.Field;
import model.player.Player;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PrisonTest {

    @Test
    public void action() {

        Field field = new Prison(19,"32","chancefelt",0, Color.red);
        Player player = new Player("jens",100,19);
        field.action(player);
        assertEquals(6,player.getPosition());

    }
}