package model.board.fields;

import model.board.Field;
import model.player.Player;

import java.awt.*;

public class Chancefield extends Field {



    /*
    -------------------------- Fields --------------------------
     */

    /*
    ----------------------- Constructor -------------------------
     */

    public Chancefield (int fieldNumber, String title, String description) {

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

        //implement draw card action to player.

    }



    /*
    ---------------------- Support Methods ----------------------
     */




}
