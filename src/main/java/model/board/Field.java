package model.board;

import model.player.Player;

import java.awt.*;

public abstract class Field {

    /*
    -------------------------- Fields --------------------------
     */

    protected int fieldNumber;
    protected String title;
    protected String description;
    protected Player owner;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Field (int fieldNumber, String title, String description) {

        this.fieldNumber=fieldNumber;
        this.title=title;
        this.description=description;

    }

    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">
    public int getCardNumber() {return fieldNumber;}

    public void setCardNumber (int fieldNumber) {this.fieldNumber = fieldNumber;}

    public String getTitle() {        return title;    }

    public void setTitle (String title) {        this.title = title;    }

    public String getDescription() {        return description;    }

    public void setDescription (String description) {        this.description = description;    }

    public Player getOwner() {        return owner;    }

    public void setOwner (Player owner) {        this.owner = owner;    }
    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    protected abstract void action (Player player);


    /*
    ---------------------- Support Methods ----------------------
     */


}

