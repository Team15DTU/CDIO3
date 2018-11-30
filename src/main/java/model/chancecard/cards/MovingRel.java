package model.chancecard.cards;

import controller.Controller;
import model.chancecard.Card;
import model.player.Player;

/**
 * @author Rasmus Sander Larsen
 * @date 19-11-2018
 */
public class MovingRel extends Card {


    /*
    -------------------------- Fields --------------------------
     */

    private int movementRel;

    /*
    ----------------------- Constructor -------------------------
     */

    public MovingRel(String cardType, String text, String description, int movementRel) {
        super(cardType, text, description);
        this.movementRel=movementRel;
    }
    
    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">

    public int getMovementRel()                 { return movementRel; }

    public void setMovementRel(int movementRel) { this.movementRel = movementRel; }

    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action(Player player) {

        int prePosition = player.getPosition();
        int finalPosition;
        if (prePosition+movementRel<=0) {
            int restMovement = Math.abs(prePosition+movementRel);
            finalPosition=24-(restMovement+prePosition); // 24 because of index 0
        } else {
            finalPosition=movementRel;
        }

        player.updatePosition(finalPosition);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}
