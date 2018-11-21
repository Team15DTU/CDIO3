package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Property extends Field {


    /*
    -------------------------- Fields --------------------------
     */

    private int cost;


    /*
    ----------------------- Constructor -------------------------
     */

    public Property (int fieldNumber, String title, String description, Color color, int cost) {

        super(fieldNumber, title, description, color);
        this.cost=cost;

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

    public int getCost() {        return cost;    }

    public void setCost(int cost) {        this.cost = cost;    }

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {
        player.//owns and
    }



    /*
    ---------------------- Support Methods ----------------------
     */



}
