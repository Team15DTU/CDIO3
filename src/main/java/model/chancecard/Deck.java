package model.chancecard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Rasmus Sander Larsen
 * @date 14-11-2018
 */
public class Deck {

    /*
    -------------------------- Fields --------------------------
     */

    ArrayList<Card> chanceDeck;
    private int numberOfSetsInDeck;

    /*
    ----------------------- Constructor -------------------------
     */

    public Deck (int numberOfSetsInDeck) {

        chanceDeck = new ArrayList<>();

        createDeck(numberOfSetsInDeck);

    }

    /*
    ------------------------ Properties -------------------------
     */



    /*
    ---------------------- Public Methods -----------------------
     */

    public void createDeck (int numberOfSetsInDeck) {

        for (int i =0; i<numberOfSetsInDeck; i++) {

            addMovingAbs(1,"Lyngbyvejen", "Ryk til Lyngbyvejen", 12);
            addMovingAbs(2, "Slikbutikken", "Ryk direkte til Slikbutikken", 6);
            addMovingRel(3, "Trappen", "Du falder ned af en trappe, ryk 2 felter tilbage", 2);
            addMovingRel(4,"Motorvejen", "Du kører på motorvejen, ryk 3 felter frem", 3);
            addTransfor(5, "Oddset", "Du har vundet i oddset og får 200 kroner", 200);


        }
    }

    public void shuffleDeck() {

        Collections.shuffle(chanceDeck);

    }

    /*
    ---------------------- Support Methods ----------------------
     */

    public void addMovingAbs (int cardNumber, String text, String description, int positionAbs) {
        chanceDeck.add(new MovingAbs(cardNumber,text,description,positionAbs));

    }

    public void addMovingRel (int cardNumber, String text, String description, int movementRel) {
        MovingRel movingRel;
        chanceDeck.add(movingRel = new MovingRel(cardNumber,text,description,movementRel));
    }

    public void addTransfor (int cardNumber, String text, String description, int money) {
        chanceDeck.add( new Transfer(cardNumber, text, description, money));
    }


}