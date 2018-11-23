package model.chancecard;

import model.chancecard.cards.MovingAbs;
import model.chancecard.cards.MovingRel;
import model.chancecard.cards.Transfer;

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

    private ArrayList<Card> chanceDeck;
    private int totalCardsInDeck;

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

            addMovingAbs("Lyngbyvejen", "Ryk til Lyngbyvejen", 12);
            addMovingAbs("Slikbutikken", "Ryk direkte til Slikbutikken", 6);
            addMovingRel("Trappen", "Du falder ned af en trappe, ryk 2 felter tilbage", -2);
            addMovingRel("Motorvejen", "Du kører på motorvejen, ryk 3 felter frem", 3);
            addTransfer ( "Oddset", "Du har vundet i oddset og får 200 kroner", 200);

        }

        totalCardsInDeck = chanceDeck.size();
    }

    public void shuffleDeck(int totalShuffles) {

        for (int i =0; i<totalShuffles; i++) {
            Collections.shuffle(chanceDeck);
        }

    }

    public void drawCard () {

        Card drawedCard = chanceDeck.get(0);
        chanceDeck.set(totalCardsInDeck-1, drawedCard);

    }

    /*
    ---------------------- Support Methods ----------------------
     */

    private void addMovingAbs ( String text, String description, int positionAbs) {
        chanceDeck.add(new MovingAbs(text,description,positionAbs));

    }

    private void addMovingRel (String text, String description, int movementRel) {
        MovingRel movingRel;
        chanceDeck.add(movingRel = new MovingRel(text,description,movementRel));
    }

    private void addTransfer(String text, String description, int money) {
        chanceDeck.add( new Transfer(text, description, money));
    }

}