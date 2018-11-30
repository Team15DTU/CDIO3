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

    public Visiting(int fieldNumber, String title, String description, int rent, Color color) {

        super(fieldNumber, title, description, rent, color);

        fieldType = "Visiting";

    }

    /*
    ------------------------ Properties -------------------------
     */


    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        actionText = "Du er landet på et besøgsfelt og nyder godt af den gratis parkering.";

    }

    /*
    ---------------------- Support Methods ----------------------
     */

}
