package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Prison extends Field {


    /*
    -------------------------- Fields --------------------------
     */


    /*
    ----------------------- Constructor -------------------------
     */

    public Prison(int fieldNumber, String title, String description, int rent, Color color) {

        super(fieldNumber, title, description, rent, color);

    }

    /*
    ------------------------ Properties -------------------------
     */


    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        System.out.println(description);
        player.setPosition(7);

    }



    /*
    ---------------------- Support Methods ----------------------
     */



}
