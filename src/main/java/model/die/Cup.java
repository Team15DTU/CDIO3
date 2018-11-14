package model.die;

public class Cup {

    /*
    ----------- Fields -----------
     */
    private int cupValue;
    private Die[] dies;

    /*
    ---------- Constructors -------
     */

    /**
     * Default constructor which creates a cup with 2 dies of 6 sides.
     */
    public Cup () {

        // Initialize
        dies = new Die[2];

        // Fill the array with 2 dies
        for( int i=0 ; i < dies.length ; i++) {
            dies[i] = new Die();
        }

        /*
        foreach loop that apparently doesn't work

        for (Die die : dies) {

            die = new Die();
        } */

    }

    /**
     * Alternative constructor, which creates a cup with "amountOfDies"
     * dies of "dieSides" sides.
     * @param amountOfDies int
     * @param dieSides int
     */
    public Cup (int amountOfDies, int dieSides) {

        // Initialize
        dies = new Die[amountOfDies];

        // Fill the array with the specified amount of dies
        for ( int i=0 ; i < dies.length ; i++ ) {
            dies[i] = new Die();
        }

        /*
        foreach loop that apparently doesn't work

        // Fill the array with the specified amount of dies
        for (Die die : dies) {
            die = new Die(dieSides);
        }

        */
    }

    /*
    -------- Public Methods -------
     */

    /**
     * This method rolls every die in the cup
     * @return Returns the total value of the facevalues in the cup
     */
    public int cupRoll () {

        int cupValue = 0;
        // Iterate through all dies and roll
        for (Die die : dies) {
            // Roll the current die
            die.roll();

            // Update cupValue
            cupValue += die.getFaceValue();

        }

        // Update this.cupValue and return it
        this.cupValue = cupValue;
        return cupValue;
    }

    /*
    --------- Support Methods ---------
     */

    /*
    --------- Variables accessible ----
     */

    public Die[] getDies() { return dies; }

    public void setDies(Die[] dies) { this.dies = dies; }

    public int getCupValue () {return cupValue;}

    public void setCupValue (int cupValue) {this.cupValue = cupValue;}

}
