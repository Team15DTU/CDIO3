package controller;

import model.board.Field;
import model.player.Player;
import view.gui.Gui;

import java.util.ArrayList;

/**
 * @author Alfred Röttger Rydahl
 */

public class Controller {

    /*
    --------------------------- Fields ---------------------------
     */

    private Gui gui;

    /*
    ------------------------ Constructors ------------------------
     */

    //<editor-fold desc="Constructors">
    /**
     * Use this constructor if you don't know the players
     * in the game
     * @param fields An Array of Field's
     */
    public Controller (Field [] fields ) {

        // Create the Gui
        gui = new Gui(fields);
    }

    /**
     * Use this controller if you already know the players
     * in the game.
     * @param players An ArrayList<Player></Player>
     * @param fields An Array of Field's
     */
    public Controller ( ArrayList<Player> players, Field[] fields ) {

        // Create the new Gui
        gui = new Gui(players, fields);
    }
    //</editor-fold>

    /*
    ------------------------- Properties -------------------------
     */

    /*
    ----------------------- Public Methods -----------------------
     */

    /**
     * Shows a message to the players
     * @param message The message as a String
     */
    public void showMessage (String message) {

        // Show the message
        gui.showMessage(message);
    }

    /**
     * This method displays a Die on the board, with the given
     * facevalue.
     * @param faceValue The value to face up on the Die
     */
    public void setDie (int faceValue) {

        // Display the Die on the board
        gui.setDie(faceValue);
    }

    //<editor-fold desc="Chancecard Methods"

    /**
     * This method sets the next ChanceCard and
     * displays it right away.
     * @param text The text to the ChanceCard.
     */
    public void setAndDisplayChanceCard (String text) {

        // Set the ChanceCard
        setChanceCard(text);

        // Then display the ChanceCard
        displayChanceCard();
    }

    /**
     * This method sets the next Chancecard, so that
     * the displayChancecard method can show the card,
     * or you can press the deck to see it.
     * @param text The text to the Chancecard
     */
    public void setChanceCard (String text) {

        // Ready the next Chancecard
        gui.setChanceCard(text);
    }

    /**
     * This method displays the next Chancecard.
     * Requires the setChancecard() method to be called
     * before, to show the desired card.
     */
    public void displayChanceCard () {

        // Display the card
        gui.displayChanceCard();
    }

    //</editor-fold>

    //<editor-fold desc="User Input">

    /**
     * Shows a message and a dropdown menu, and returns the
     * choosen String
     * @param message The information to the user
     * @param options The available options as Strings
     * @return Returns the choosen String as String
     */
    public String getUserChoice (String message, String ... options) {

        // Return the String
        return gui.getUserChoice(message, options);
    }

    /**
     * Shows a message and a dropdown menu, and returns the
     * choosen String.
     * @param message The information to the user
     * @param options The available options as String[]
     * @return the choosen String as String
     */
    public String getUserChoice (String message, ArrayList<String> options) {

        String[] hej = options.toArray( new String [options.size()]);

        // Return the String
        return gui.getUserChoice(message, hej);
    }

    /**
     * This method prompts the user to input an Integer
     * in range min - max, and prints the message
     * @param message The message to inform the user
     * @param min The minimum allowable int
     * @param max the maximum allowable int
     * @return Return the input as an int
     */
    public int getUserInteger (String message, int min, int max) {

        // Get the user integer in range min - max
        return gui.getUserInteger(message, min, max);
    }

    /**
     * This method is prompting the user to input a
     * String, and prints a given message.
     * @param message The message to inform the user
     * @return Return the input as an int
     */
    public int getUserInteger (String message) {

        // Get the user int
        return gui.getUserInteger(message);
    }

    /**
     * his method prompts the user to input a String into
     * a textfield, and returns the inputted String.
     * @param message An informal message to the user.
     * @return Returns the input as a String
     */
    public String getUserString (String message) {

        // Prompt the user for a String and Return
        return gui.getUserString(message);
    }
    //</editor-fold>

    //<editor-fold desc="Player methods">
    /**
     * Updates the players visual balance.
     * @param player The Player which balance shall be updated.
     * @param newBalance The new absolute balance of the player
     */
    public void updatePlayerBalance ( Player player, int newBalance ) {

        // Update the Balance
        gui.updatePlayerBalance( player, newBalance );
    }

    /**
     * This method moves the given player to the Field with the
     * corresponding index.
     * @param player The Player object
     */
    public void movePlayer ( Player player ) {

        // Move the Player in the gui
        gui.movePlayer ( player, player.getPosition() );

    }

    /**
     * Adds the given list of Players to the gui
     * @param players The ArrayList<Player></Player>
     */
    public void addPlayers ( ArrayList<Player> players ) {

        // Add the players
        gui.addPlayers(players);
    }

    /**
     * Adds the given Player to the gui
     * @param player The Player object to be added
     */
    public void addPlayer ( Player player ) {

        // Add the player to the gui
        gui.addPlayer(player);
    }
    //</editor-fold>

    //<editor-fold desc="Field Methods">

    /**
     * This method changes the owner of the field and
     * displays it.
     * @param player The Player which shall own the field
     * @param field The field to be owned
     */
    public void setFieldOwner (Player player, Field field) {

        // Set the new owner of the field
        gui.setFieldOwner(player, field);
    }

    //</editor-fold>

    /*
    ----------------------- Support Methods ----------------------
     */
}
