package model.player.token;

/**
 * @author Alfred Röttger Rydahl
 * @date 16-11-2018
 */
public class Token {

    /*
    ---------------------------------- Fields ----------------------------------
     */

    private String type;
    
    /*
    ------------------------------ Constructors --------------------------------
     */
    /**
     * Creates a Token of the specified type
     * @param type The type of the Token as a String
     */
    Token(String type) {
        this.type = type;
    }
    /*
    ------------------------------ Properties ----------------------------------
     */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    /*
    ---------------------------- Public Methods --------------------------------
     */
    
    /*
    ----------------------------- Support Methods ------------------------------
     */
}
