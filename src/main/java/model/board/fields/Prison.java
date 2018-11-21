package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Prison extends Field {


    /*
    -------------------------- Fields --------------------------
     */


    /*
    ----------------------- Constructor -------------------------
     */

    public Prison(int fieldNumber, String title, String description) {

        super(fieldNumber, title, description);

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

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player) {

        System.out.println(description);
        player.setPosition(7);

    }



    /*
    ---------------------- Support Methods ----------------------
     */



}
