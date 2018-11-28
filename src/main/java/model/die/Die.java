package model.die;

import java.util.Random;

public class Die {

    // Fields

    private int faceValue;          // Value of model.die after roll
    private final int DIESIDES = 6; // Sides on model.die
    private int sides;              // Sides for custom sides on model.die

    // Constructors

    /**
     * Default constructor, which creates a Die with 6 sides
     */
    public Die () {

        sides = DIESIDES;
    }

    /**
     * Alternate constructor, which creates a Die with "sides" amount of sides
     * @param sides int
     */
    public Die (int sides) {

        this.sides = sides;
    }

    // Public Methods

    public void roll () { //

        Random generator = new Random();

        faceValue = generator.nextInt(sides)+1; // Random number om model.die with DIESIDES

    }

    // Make values accessible

    public int getFaceValue () { return faceValue; }

    public void setFaceValue  (int faceValue ) { this.faceValue = faceValue; }

    public int getSides () { return sides; }

    public void setSides ( int sides ) { this.sides = sides; }
}

