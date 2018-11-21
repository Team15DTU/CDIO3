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

    public MovingAbs(int cardNumber, String text, String description, int positionAbs) {
        super(cardNumber, text, description);
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

    @Override
    public void action ( Player player ) {

        player.setPosition(positionAbs);

    }

    /*
    ---------------------- Support Methods ----------------------
     */


}
