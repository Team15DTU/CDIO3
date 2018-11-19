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

    /*
    ----------------------- Constructor -------------------------
     */

    public Deck (int numberOfCardsInDeck) {

        chanceDeck = new ArrayList<>();

        for (int i = 0; i < numberOfCardsInDeck; i++) {

            Card card = new Card(i);

            chanceDeck.add(card);

        }
    }

    /*
    ------------------------ Properties -------------------------
     */



    /*
    ---------------------- Public Methods -----------------------
     */

    public void shuffleDeck() {

        Collections.shuffle(chanceDeck);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}