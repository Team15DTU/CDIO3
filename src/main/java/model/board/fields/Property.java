package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Property extends Field {


    /*
    -------------------------- Fields --------------------------
     */

    private int cost;
    private Color color;


    /*
    ----------------------- Constructor -------------------------
     */

    public Property (int fieldNumber, String title, String description, int rent, Color color) {

        super(fieldNumber, title, description,rent, color);
        this.cost=cost;

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
            System.out.println("You bought this field for "+cost);
            setOwner(player);
            player.getAccount().update(-cost);
        } else {
            System.out.println("You are staying at "+owner.getName()+"'s place at a cost of "+cost);
            player.getAccount().update(-cost);
            owner.getAccount().update(cost);
        }
    }



    /*
    ---------------------- Support Methods ----------------------
     */



}
