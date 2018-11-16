package model.player.token;

import java.util.ArrayList;

/**
 * @author Alfred Röttger Rydahl
 * @date 16-11-2018
 */
public class TokenList {

    /*
    ---------------------------------- Fields ----------------------------------
     */
    private ArrayList<Token> list;
    
    /*
    ------------------------------ Constructors --------------------------------
     */

    /**
     *
     */
    public TokenList() {
        // Initialize
        list = new ArrayList<>(4);

        // Set the Monopoly relevant Tokens in the list
        list.add(new Token("RaceCar"));
        list.add(new Token("Car"));
        list.add(new Token("Tractor"));
        list.add(new Token("UFO"));
    }
    /*
    ------------------------------ Properties ----------------------------------
     */
    
    /*
    ---------------------------- Public Methods --------------------------------
     */
    
    /*
    ----------------------------- Support Methods ------------------------------
     */
}
