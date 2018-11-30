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

    protected String title;
    protected String description;
    protected String cardType;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Card (String cardType, String title, String description) {

        this.cardType=cardType;
        this.title = title;
        this.description=description;

    }

    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">


    public String getTitle()                         { return title; }

    public void setTitle(String title)                { this.title = title; }

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
