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

        createDeck(numberOfSetsInDeck);

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

            addMovingAbs("movingAbs","Start", "Ryk frem til Start", 0);
            addMovingAbs("movingAbs","Sommerdag", "Det er 30 grader og du trænger til en dukkert. Ryk til Svømmningpoolen",11);
            addMovingRel("movingRel","Motorvej", "Du har fart på, Ryk 5 felter fren", 5);
            addMovingRel("movingRel","Kæden faldt af", "Kæden på din cykel faldt af. Ryk 2 felter tilbage", -2);
            addMovingRel("movingRel","Forlomme", "Du får en forlomme i køen", 1);
            addTransfer("transfer","For meget slik", "Du har spist for meget slik. Betal 2 pengesedler til banken", -2);
            addTransfer("transfer","Lommepenge", "Du har taget opvasken i en uge. Modtag 1 pengesedler", 1);
            addMovingAbs("movingAbs","Strandpromenaden", "Ryk frem til Strandpromenaden", 23);
            addTransfer("transfer","Lektier", "Du har lavet alle dine lektier. Modtag 2 pengesedler fra Banken", 2);
            addTransfer("transfer","Biografen", "Du skal i biografen med dine venner. Betal 1 pengesedler", -1);

        }

        totalCardsInDeck = chanceDeck.size();
    }

    public void movingRelDeck (int numberOfSetsInDeck) {
     addMovingRel("movingRel", "RYk 2 felter tilbage","Ryk 2 felter tilabe",-2);
        addMovingRel("movingRel", "RYk 7 felter tilbage","Ryk 7 felter tilabe",-7);
        addMovingRel("movingRel", "RYk 5 felter tilbage","Ryk 5 felter tilabe",-5);
        addMovingRel("movingRel", "RYk 3 felter tilbage","Ryk 3 felter tilabe",-3);
        addMovingRel("movingRel", "RYk 4 felter tilbage","Ryk 4 felter tilabe",-4);
        addMovingRel("movingRel", "RYk 1 felter tilbage","Ryk 1 felter tilabe",-1);
        addMovingRel("movingRel", "RYk 7 felter frem","Ryk 7 felter frem",7);
        addMovingRel("movingRel","Ryk 6 felter frem", "ryk 6 felter frem",6);
        addMovingRel("movingRel","Ryk 5 felter frem", "ryk 5 felter frem",5);
        addMovingRel("movingRel","Ryk 4 felter frem", "ryk 4 felter frem",4);
        addMovingRel("movingRel","Ryk 3 felter frem", "ryk 3 felter frem",3);
        addMovingRel("movingRel","Ryk 2 felter frem", "ryk 2 felter frem",2);

    }    public void movingAbsDeck (int numberOfSetsInDeck) {
        addMovingAbs("movingAbs", "Feild= 2 ","Feild= 2 ",2);
        addMovingAbs("movingAbs", "Feild= 4 ","Feild= 4 ",4);
        addMovingAbs("movingAbs", "Feild= 6 ","Feild= 6 ",6);
        addMovingAbs("movingAbs", "Feild= 8 ","Feild= 8 ",8);
        addMovingAbs("movingAbs", "Feild= 11 ","Feild= 11 ",11);
        addMovingAbs("movingAbs", "Feild= 17 ","Feild= 17 ",17);
        addMovingAbs("movingAbs", "Feild= 23 ","Feild= 23 ",23);
        addMovingAbs("movingAbs", "Feild= 21 ","Feild= 2 ",21);
        addMovingAbs("movingAbs", "Feild= 15 ","Feild= 15 ",15);


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

    private void addMovingAbs (String cardType, String text, String description, int positionAbs) {
        chanceDeck.add(new MovingAbs(cardType,text,description,positionAbs));

    }

    private void addMovingRel (String cardType,String text, String description, int movementRel) {
        chanceDeck.add(new MovingRel(cardType,text,description,movementRel));
    }

    private void addTransfer(String cardType,String text, String description, int money) {
        chanceDeck.add( new Transfer(cardType,text,description,money));
    }


}