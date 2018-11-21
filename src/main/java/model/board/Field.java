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

        public void setCardNumber(int cardNumber) {this.fieldNumber = fieldNumber;}


    public String getTitle() {        return title;    }

    public void setTitle(String title) {        this.title = title;    }

    public String getDescription() {        return description;    }

    public void setDescription(String description) {        this.description = description;    }

    public int getCost() {        return cost;    }

    public void setCost(int cost) {        this.cost = cost;    }

    public int getRent() {        return rent;    }

    public void setRent(int rent) {        this.rent = rent;    }

    /*
    ---------------------- Public Methods -----------------------
     */

    protected void action (Player player) {}


    /*
    ---------------------- Support Methods ----------------------
     */


}
