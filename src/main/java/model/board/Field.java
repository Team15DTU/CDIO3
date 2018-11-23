package model.board;

import model.player.Player;

import java.awt.*;

public abstract class Field {

    /*
    -------------------------- Fields --------------------------
     */

    protected int fieldNumber, cost;
    protected String title;
    protected String description;
    protected Player owner;
    protected Color color;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Field(int fieldNumber, String title, String description, int cost, Color color) {

        this.fieldNumber=fieldNumber;
        this.title=title;
        this.description=description;
        this.cost=cost;
        this.color=color;

    }

    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public int getFieldNumber() { return fieldNumber; }

    public void setFieldNumber(int fieldNumber) { this.fieldNumber = fieldNumber; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Player getOwner() { return owner; }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    protected abstract void action (Player player);


    /*
    ---------------------- Support Methods ----------------------
     */


}

