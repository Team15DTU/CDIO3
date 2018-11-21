package model.board;

import model.player.Player;

import java.awt.*;

public abstract class Field {

    /*
    -------------------------- Fields --------------------------
     */

    protected int fieldNumber, rent;
    protected String title;
    protected String description;
    protected Player owner;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Field (int fieldNumber, String title, String description, int rent) {

        this.fieldNumber=fieldNumber;
        this.title=title;
        this.description=description;
        this.rent=rent;

    }

    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">

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

    public int getRent() { return rent; }

    public void setRent(int rent) { this.rent = rent; }

    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    protected abstract void action (Player player);


    /*
    ---------------------- Support Methods ----------------------
     */


}

