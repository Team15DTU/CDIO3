package model.chancecard;

import model.player.Player;

/**
 * @author Rasmus Sander Larsen
 * @date 19-11-2018
 */
public class Transfer extends Card {


    /*
    -------------------------- Fields --------------------------
     */

    private int moneyTransfered;

    
    /*
    ----------------------- Constructor -------------------------
     */

    public Transfer(int cardNumber, String text, String description, int money) {

        super(cardNumber, text, description);
        moneyTransfered=money;

    }
    
    
    /*
    ------------------------ Properties -------------------------
     */
    
    
    
    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player1, Player player2) {

        player1.updateScore(-1*moneyTransfered);
        player2.updateScore(1*moneyTransfered);

    }
    
    
    /*
    ---------------------- Support Methods ----------------------
     */


}
