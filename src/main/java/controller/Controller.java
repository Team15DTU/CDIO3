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
    public Controller ( Field[] fields ) {

        // Create the Gui
        gui = new Gui( fields );
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

    //<editor-fold desc="User Input">
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
     * @param theFieldIndex The Index of the Field
     */
    public void movePlayer ( Player player, int theFieldIndex ) {

        // Move the Player in the gui
        gui.movePlayer ( player, theFieldIndex );
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

    /*
    ----------------------- Support Methods ----------------------
     */
}
