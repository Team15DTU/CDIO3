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

    public MovingRel(String text, String description, int movementRel) {
        super(text, description);
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
        // TODO: Er det ikke bedre at updatePosition end at sette den?
        /*
        int prePosition = player.getPosition(), currentPosition;

        currentPosition = prePosition + movementRel;
        player.setPosition(currentPosition);
        */

        player.updatePosition(movementRel);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}
