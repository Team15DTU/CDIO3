package Chancecard;

import model.chancecard.Chancecard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @auther Rasmus Sander Larsen
 * @date 14-11-2018
 */
public class Deck {

    /*
    -------------------------- Fields --------------------------
     */

    ArrayList<Chancecard> chanceDeck;

    /*
    ----------------------- Constructor -------------------------
     */

    public Deck (int numberOfCardsInDeck) {

        chanceDeck = new ArrayList<>();

        for (int i = 0; i < numberOfCardsInDeck; i++) {

            Chancecard chancecard = new Chancecard(i);

            chanceDeck.add(chancecard);

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