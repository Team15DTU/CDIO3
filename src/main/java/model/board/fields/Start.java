package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Start extends Field { //start could be an instance of 'visiting'


    /*
    -------------------------- Fields --------------------------
     */

    /*
    ----------------------- Constructor -------------------------
     */

    public Start(int fieldNumber, String title, String description) {

        super(fieldNumber, title, description);

    }

    /*
    ------------------------ Properties -------------------------
     */


    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        System.out.println(description);
        //payment of startline is handled elsewhere.

    }



    /*
    ---------------------- Support Methods ----------------------
     */



}
