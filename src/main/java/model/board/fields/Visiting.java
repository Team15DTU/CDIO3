package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Visiting extends Field { //this class is used for visiting prison and for parking


    /*
    -------------------------- Fields --------------------------
     */

    /*
    ----------------------- Constructor -------------------------
     */

    public Visiting(int fieldNumber, String title, String description) {

        super(fieldNumber, title, description);

    }

    /*
    ------------------------ Properties -------------------------
     */


    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        System.out.printf(description);

    }


    /*
    ---------------------- Support Methods ----------------------
     */



}
