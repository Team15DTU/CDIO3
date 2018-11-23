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

            addMovingAbs("Start", "Ryk frem til Start", 0);
            addMovingRel("Motorvej", "Du har fart på, Ryk 5 felter fren", 5);
            addMovingRel("Forlomme", "Du får en forlomme i køen", 1);
            addTransfer("For meget slik", "Du har spist for meget slik. Betal 2 pengesedler til banken", 2);
            addMovingAbs("Strandpromenaden", "Ryk frem til Strandpromenaden", 23);
            addTransfer("Lektier", "Du har lavet alle dine lektier. Modtag 2 pengesedler fra Banken", 2);

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