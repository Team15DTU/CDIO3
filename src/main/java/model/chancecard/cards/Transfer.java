package model.chancecard.cards;

import controller.Controller;
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

    public Transfer(String text, String description, int money) {

        super(text, description);
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

    public void action(Player player) {

        player.updateScore(moneyTransferred);
    }
    
    
    /*
    ---------------------- Support Methods ----------------------
     */


}
