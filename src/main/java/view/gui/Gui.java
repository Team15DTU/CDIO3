package view.gui;

import gui_fields.*;
import gui_main.GUI;
import model.board.Field;
import model.player.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Alfred Röttger Rydahl
 * @date 19-11-2018
 */
public class Gui {

    /*
    ---------------------------------- Fields ----------------------------------
     */

    private GUI gui;
    private GUI_Field[] fields;
    private ArrayList<GUI_Player> players;
    private Color backgroundColor;

    
    /*
    ------------------------------ Constructors --------------------------------
     */

    /**
     * This Constructor creates a visual board, with the given fields.
     * @param fields The list of Field's as Field[]
     */
    public Gui ( Field[] fields ) {

        // Initialize Player ArrayList
        this.players = new ArrayList<>();

        // Create the GUI_Field array
        this.fields = createPropertyFields(fields);

        // Set Color
        backgroundColor = Color.GRAY;

        // Start GUI
        gui = new GUI(this.fields, backgroundColor);

    }

    /**
     * Constructor to use if the player list is known, and then creates
     * a visual board with the given fields.
     * @param players The Player list as an ArrayList<Player>
     * @param fields The list of Field's as Field[]
     */
    public Gui ( ArrayList<Player> players, Field[] fields ) {

        // Create the GUI_Player array
        this.players = createPlayers(players);

        // Create the GUI_Field array
        this.fields = createPropertyFields(fields);

        // Set Color
        backgroundColor = Color.GRAY;

        // Start GUI
        gui = new GUI(this.fields, backgroundColor);
        for (GUI_Player player : this.players) {
            gui.addPlayer(player);
        }
    }
    
    /*
    ------------------------------ Properties ----------------------------------
     */
    
    /*
    ---------------------------- Public Methods --------------------------------
     */

    /**
     *
     * @param player
     * @param fieldsToMove
     */
    public void movePlayerAbs ( Player player, int fieldsToMove ) {

        // Find the player in the GUI_Player list
        GUI_Player playerToMove = findPlayer(player);

        // Move the player on the board

    }

    /**
     * This method adds an ArrayList of players to the game.
     * @param players An ArrayList<Player></Player>
     */
    public void addPlayers ( ArrayList<Player> players ) {

        // Iterate over the players list and add the player
        for ( Player player : players ) {
            addPlayer(player);
        }
    }

    /**
     * This method adds a new Player to the game.
     * @param player The Player to add
     */
    public void addPlayer ( Player player ) {

        // Create the GUI_Player
        GUI_Player newPlayer = new GUI_Player(  player.getName(),
                player.getAccount().getBalance(),
                new GUI_Car(Color.RED, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED)
                );

        // Add the player to the gui
        addGUIPlayer(newPlayer);
    }
    
    /*
    ----------------------------- Support Methods ------------------------------
     */

    /**
     * Finds the corresponding GUI_Player in the list
     * @param player The player to find
     * @return Returns the found GUI_Player or null
     */
    private GUI_Player findPlayer ( Player player ) {

        // Declare GUI_Player variable
        GUI_Player playerToFind = null;

        // Find the player
        for ( GUI_Player p : players ) {

            // Check if the name corresponds
            if ( p.getName().equals(player.getName()) ) {
                playerToFind = p;
                break;
            }
        }

        // Return the found GUI_Player
        return playerToFind;
    }

    /**
     * This method has the responsibility to add a new player to
     * this objects GUI_Player list and to the visual board.
     * @param player A GUI_Player to add
     */
    private void addGUIPlayer ( GUI_Player player ) {

        // Add to the GUI_Player list
        players.add(player);
        // Add the GUI_Player to the visual gui
        gui.addPlayer(player);
    }

    /**
     * This method helps the constructor create an Array of GUI_Field's
     * @param fields An Array of type Field
     * @return Return an Array of type GUI_Field
     */
    private GUI_Field[] createPropertyFields(Field[] fields ) {

        // Create the GUI_Field array
        GUI_Field[] newFields = new GUI_Field[fields.length];

        // Iterate through fields and create GUI_Ownable for each
        for ( int i=0 ; i < fields.length ; i++ ) {

            // Create new GUI_Street
            GUI_Street ownable = new GUI_Street(fields[i].getTitle(), "subtext", fields[i].getDescription(),
                                                fields[i].getLeje(), Color.BLACK, Color.RED);

            newFields[i] = ownable;
        }

        // Return the newly created array
        return newFields;
    }

    /**
     * This method helps the constructor create an Array of GUI_Player's
     * @param players An ArrayList<Player>
     * @return Return an ArrayList<GUI_Player>
     */
    private ArrayList<GUI_Player> createPlayers (ArrayList<Player> players) {

        // Create the players arraylist as the right size
        ArrayList<GUI_Player> guiPlayers = new ArrayList<>(players.size());

        // Iterate over the players list and create a GUI_Player for each
        for ( int i=0 ; i < players.size() ; i++ ) {
            GUI_Player newPlayer = new GUI_Player(  players.get(i).getName(),
                                                    players.get(i).getAccount().getBalance(),
                                                    new GUI_Car(Color.RED, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED)
                                                    );

            // Add the created player to the player array
            guiPlayers.add(newPlayer);
        }

        // Return the GUI_Player array
        return guiPlayers;
    }
}
