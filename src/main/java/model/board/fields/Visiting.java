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

    public Visiting(int fieldNumber, String title, String description, int rent) {

        super(fieldNumber, title, description, rent);

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
