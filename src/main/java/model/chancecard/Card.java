package model.chancecard;

import model.player.Player;

/**
 * @author Rasmus Sander Larsen
 * @date 14-11-2018
 */

public abstract class Card {
    
    /*
    -------------------------- Fields --------------------------
     */

    protected int cardNumber;
    protected String text;
    protected String description;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Card (int cardNumber,String text, String description) {

        this.cardNumber=cardNumber;
        this.text=text;
        this.description=description;

    }

    /*
    ------------------------ Properties -------------------------
     */

    public int getCardNumber() { return cardNumber; }

    public void setCardNumber(int cardNumber) { this.cardNumber = cardNumber; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    protected String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    /*
    ---------------------- Public Methods -----------------------
     */

    protected abstract void action (Player player);
    
    
    
    /*
    ---------------------- Support Methods ----------------------
     */


}
