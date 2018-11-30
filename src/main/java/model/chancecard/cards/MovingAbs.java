package model.chancecard.cards;

import model.chancecard.Card;
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

    public MovingAbs(String cardType,String text, String description, int positionAbs) {
        super(cardType,text, description);
        this.positionAbs=positionAbs;
    }
    
    /*
    ------------------------ Properties -------------------------
     */

    //<editor-fold desc="Properties">

    public int getPositionAbs()                 { return positionAbs; }

    public void setPositionAbs(int positionAbs) { this.positionAbs = positionAbs; }

    //</editor-fold>

    /*
    ---------------------- Public Methods -----------------------
     */

    public void action(Player player) {

        int prePosition = player.getPosition();
        int finalPositionUpdate;
        if (prePosition>positionAbs) {
            int diffPassed = 23-prePosition;
            finalPositionUpdate = positionAbs + diffPassed + 1; // +1 for 0 in index
        } else {
            finalPositionUpdate= positionAbs-prePosition;
        }

        player.updatePosition(finalPositionUpdate);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}
