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
        protected Color color;
        protected Player owner = null;

    /*
    ----------------------- Constructor -------------------------
     */

        protected Field (int fieldNumber, String title, String description, Color color) {

            this.fieldNumber=fieldNumber;
            this.title=title;
            this.description=description;
            this.color = color;

        }

    /*
    ------------------------ Properties -------------------------
     */

    public int getCardNumber() {return fieldNumber;}

    public void setCardNumber(int fieldNumber) {this.fieldNumber = fieldNumber;}

    public String getTitle() {        return title;    }

    public void setTitle(String title) {        this.title = title;    }

    public String getDescription() {        return description;    }

    public void setDescription(String description) {        this.description = description;    }

    public Player getOwner() {        return owner;    }

    public void setOwner(Player owner) {        this.owner = owner;    }

    /*
    ---------------------- Public Methods -----------------------
     */

    protected void action (Player player) {}


    /*
    ---------------------- Support Methods ----------------------
     */


}

