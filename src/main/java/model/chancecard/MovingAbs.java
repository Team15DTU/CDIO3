package model.chancecard;

import model.player.Player;

/**
 * @author Rasmus Sander Larsen
 * @date 19-11-2018
 */
public class MovingAbs extends Card {


    /*
    -------------------------- Fields --------------------------
     */
    
    private int positionAbs;

    /*
    ----------------------- Constructor -------------------------
     */

    public MovingAbs(int cardNumber, String text, String description, int positionAbs) {
        super(cardNumber, text, description);
        this.positionAbs=positionAbs;
    }
    
    /*
    ------------------------ Properties -------------------------
     */
    
    
    
    /*
    ---------------------- Public Methods -----------------------
     */

    public void action (Player player, int positionAbs) {

        player.setPosition(positionAbs);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}
