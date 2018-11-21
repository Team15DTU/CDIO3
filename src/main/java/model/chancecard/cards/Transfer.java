package model.chancecard.cards;

import model.chancecard.Card;
import model.player.Player;

/**
 * @author Rasmus Sander Larsen
 * @date 19-11-2018
 */
public class Transfer extends Card {


    /*
    -------------------------- Fields --------------------------
     */

    private int moneyTransferred;

    
    /*
    ----------------------- Constructor -------------------------
     */

    public Transfer(int cardNumber, String text, String description, int money) {

        super(cardNumber, text, description);
        moneyTransferred = money;

    }
    
    
    /*
    ------------------------ Properties -------------------------
     */
    
    //<editor-fold desc="Properties">

    public int getMoneyTransferred()                        { return moneyTransferred; }

    public void setMoneyTransferred(int moneyTransferred)   { this.moneyTransferred = moneyTransferred; }

    //</editor-fold>
    
    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player1) {

        player1.updateScore(moneyTransferred);
    }
    
    
    /*
    ---------------------- Support Methods ----------------------
     */


}