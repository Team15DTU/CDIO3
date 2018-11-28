package model.board.fields;

import model.board.Field;
import model.player.Player;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class VisitingTest {

    @Test
    public void action() {

        Field visiting = new Visiting(1,"titel","dette er her",0, Color.red);
        Player player = new Player("jens",100,1);
        visiting.action(player);

        assertEquals("Du er landet på et besøgsfelt og din pengebeholdning er konstant",visiting.getActionText());

    }
}