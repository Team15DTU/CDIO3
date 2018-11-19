package model.chancecard;

/**
 * @author Rasmus Sander Larsen
 * @date 14-11-2018
 */

public abstract class Card {
    
    /*
    -------------------------- Fields --------------------------
     */

    protected int cardNumber;
    protected String text;
    protected String description;

    /*
    ----------------------- Constructor -------------------------
     */

    protected Card(int cardNumber,String text, String description) {

        this.cardNumber=cardNumber;
        this.text=text;
        this.description=description;

    }

    /*
    ------------------------ Properties -------------------------
     */



    /*
    ---------------------- Public Methods -----------------------
     */

    protected void action () {



    }
    
    
    
    /*
    ---------------------- Support Methods ----------------------
     */


}
