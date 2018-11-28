package model.chancecard;

import model.chancecard.cards.MovingAbs;
import model.chancecard.cards.MovingRel;
import model.chancecard.cards.Transfer;
import model.player.Player;

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

        fixedDeck(numberOfSetsInDeck);

    }

    /*
    ------------------------ Properties -------------------------
     */

    public ArrayList<Card> getChanceDeck() {
        return chanceDeck;
    }

    public void setChanceDeck(ArrayList<Card> chanceDeck) {
        this.chanceDeck = chanceDeck;
    }

    public int getTotalCardsInDeck() {
        return totalCardsInDeck;
    }

    public void setTotalCardsInDeck(int totalCardsInDeck) {
        this.totalCardsInDeck = totalCardsInDeck;
    }

/*
    ---------------------- Public Methods -----------------------
     */

    public void createDeck (int numberOfSetsInDeck) {

        for (int i =0; i<numberOfSetsInDeck; i++) {

            addMovingAbs("Start", "Ryk frem til Start", 0);
            addMovingAbs("Sommerdag", "Det er 30 grader og du trænger til en dukkert. Ryk til Svømmningpoolen",11);
            addMovingRel("Motorvej", "Du har fart på, Ryk 5 felter fren", 5);
            addMovingRel("Kæden faldt af", "Kæden på din cykel faldt af. Ryk 2 felter tilbage", -2);
            addMovingRel("Forlomme", "Du får en forlomme i køen", 1);
            addTransfer("For meget slik", "Du har spist for meget slik. Betal 2 pengesedler til banken", -2);
            addTransfer("Lommepenge", "Du har taget opvasken i en uge. Modtag 1 pengesedler", 1);
            addMovingAbs("Strandpromenaden", "Ryk frem til Strandpromenaden", 23);
            addTransfer("Lektier", "Du har lavet alle dine lektier. Modtag 2 pengesedler fra Banken", 2);
            addTransfer("Biografen", "Du skal i biografen med dine venner. Betal 1 pengesedler", -1);

        }

        totalCardsInDeck = chanceDeck.size();
    }

    public void fixedDeck (int numberOfSetsInDeck) {
        addMovingAbs("hejhej","Hejhej",14);
    }

    public void shuffleDeck(int totalShuffles) {

        for (int i =0; i<totalShuffles; i++) {
            Collections.shuffle(chanceDeck);
        }

    }

    public Card drawCard () {

        Card drawCard = chanceDeck.get(0);
        chanceDeck.remove(0);
        chanceDeck.add(drawCard);

        return drawCard;
    }

    /*
    ---------------------- Support Methods ----------------------
     */

    private void addMovingAbs ( String text, String description, int positionAbs) {
        chanceDeck.add(new MovingAbs(text,description,positionAbs));

    }

    private void addMovingRel (String text, String description, int movementRel) {
        chanceDeck.add(new MovingRel(text,description,movementRel));
    }

    private void addTransfer(String text, String description, int money) {
        chanceDeck.add( new Transfer(text, description, money));
    }


}