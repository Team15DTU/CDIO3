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

        fieldType = "Prison";
    }

    /*
    ------------------------ Properties -------------------------
     */


    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        actionText = "Du er landet på fængslet og du bliver sendt tilbage til felt 7";
        player.setPosition(6);

    }



    /*
    ---------------------- Support Methods ----------------------
     */



}
