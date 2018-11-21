package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Chancefield extends Field {



    /*
    -------------------------- Fields --------------------------
     */

    /*
    ----------------------- Constructor -------------------------
     */

    public Chancefield (int fieldNumber, String title, String description, int rent) {

        super(fieldNumber, title, description, rent);

    }

    /*
    ------------------------ Properties -------------------------
     */

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        //implement draw card action to player.

    }



    /*
    ---------------------- Support Methods ----------------------
     */




}
