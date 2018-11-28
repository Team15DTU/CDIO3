package model.chancecard;

import controller.Controller;
import model.player.Player;

/**
 * @author Rasmus Sander Larsen
 * @date 14-11-2018
 */

public abstract class Card {
    
    /*
    -------------------------- Fields --------------------------
     */

    protected String text;
    protected String description;
    protected String cardType;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Card (String cardType,String text, String description) {

        this.cardType=cardType;
        this.text=text;
        this.description=description;

    }

    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">


    public String getText()                         { return text; }

    public void setText(String text)                { this.text = text; }

    public String getDescription()                  { return description; }

    public void setDescription(String description)  { this.description = description; }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action(Player player){}

    /*
    ---------------------- Support Methods ----------------------
     */


}
