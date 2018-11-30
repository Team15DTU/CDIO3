package model.board.fields;

import model.board.Field;
import model.chancecard.Card;
import model.chancecard.Deck;
import model.player.Player;

import java.awt.*;

public class Chancefield extends Field {



    /*
    -------------------------- Fields --------------------------
     */

    /*
    ----------------------- Constructor -------------------------
     */

    public Chancefield (int fieldNumber, String title, String description, int rent, Color color) {

        super(fieldNumber, title, description, rent, color);

        fieldType = "Chancefield";

    }

    /*
    ------------------------ Properties -------------------------
     */

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player, Deck deck) {

        actionText = "Du er landet på et chance felt og trækker et chancekort. \nDu kan se konsekvensen af kortet i midten af spillepladen.";
        Card drawCard= deck.drawCard();
        drawCard.action(player);

    }

    /*
    ---------------------- Support Methods ----------------------
     */




}
