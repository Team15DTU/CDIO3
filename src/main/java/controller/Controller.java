package controller;

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

    /*
    ------------------------- Properties -------------------------
     */
    /*
    ----------------------- Public Methods -----------------------
     */

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
    /*
    ----------------------- Support Methods ----------------------
     */
}
