package model.chancecard.cards;

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
    @Override
    public void action (Player player) {

        int prePosition = player.getPosition();
        int currentPosition;

        currentPosition = prePosition+ movementRel;
        player.setPosition(currentPosition);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}
