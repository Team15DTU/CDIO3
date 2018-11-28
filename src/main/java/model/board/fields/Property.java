package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Property extends Field {


    /*
    -------------------------- Fields --------------------------
     */


    /*
    ----------------------- Constructor -------------------------
     */

    public Property (int fieldNumber, String title, String description, int rent, Color color) {

        super(fieldNumber, title, description,rent, color);

        fieldType = "Property";
    }

    /*
    ------------------------ Properties -------------------------
     */



    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        if (owner == null) {
            actionText = "Du køber dette felt for " + cost + " pengeseddel\n";
            setOwner(player);
            player.getAccount().update(-cost);
            player.getPropertyCost().add(cost);
        } else {
            actionText = "Du er landet på "+ owner.getName() + "'s felt, hvilket koster " + cost + " pengesedler";
            player.getAccount().update(-cost);
            owner.getAccount().update(cost);
        }
    }


    /*
    ---------------------- Support Methods ----------------------
     */

}
