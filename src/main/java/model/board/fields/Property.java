package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Property extends Field {


    /*
    -------------------------- Fields --------------------------
     */

    private Color color;


    /*
    ----------------------- Constructor -------------------------
     */

    public Property (int fieldNumber, String title, String description, int rent, Color color) {

        super(fieldNumber, title, description,rent, color);

    }

    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">
    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }
    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        if (owner == null) {
            setOwner(player);
            player.getAccount().update(-cost);
            player.getPropertyCost().add(cost);
        } else {
            player.getAccount().update(-cost);
            owner.getAccount().update(cost);
        }
    }


    /*
    ---------------------- Support Methods ----------------------
     */

}
