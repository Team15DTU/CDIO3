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

            addMovingAbs(1,"Lyngbyvejen", "Ryk til Lyngbyvejen", 12);
            addMovingAbs(2, "Slikbutikken", "Ryk direkte til Slikbutikken", 6);
            addMovingRel(3, "Trappen", "Du falder ned af en trappe, ryk 2 felter tilbage", -2);
            addMovingRel(4,"Motorvejen", "Du kører på motorvejen, ryk 3 felter frem", 3);
            addTransfer(5, "Oddset", "Du har vundet i oddset og får 200 kroner", 200);

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

    private void addMovingAbs (int cardNumber, String text, String description, int positionAbs) {
        chanceDeck.add(new MovingAbs(cardNumber,text,description,positionAbs));

    }

    private void addMovingRel (int cardNumber, String text, String description, int movementRel) {
        MovingRel movingRel;
        chanceDeck.add(movingRel = new MovingRel(cardNumber,text,description,movementRel));
    }

    private void addTransfer(int cardNumber, String text, String description, int money) {
        chanceDeck.add( new Transfer(cardNumber, text, description, money));
    }

}