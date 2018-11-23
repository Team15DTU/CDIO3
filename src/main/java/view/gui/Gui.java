package view.gui;

import gui_fields.*;
import gui_main.GUI;
import model.board.Field;
import model.board.fields.*;
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

    //<editor-fold desc="Fields">
    private GUI gui;
    private GUI_Field[] fields;
    private ArrayList<GUI_Player> players;
    private Color backgroundColor;
    private Color textColor = Color.BLACK;
    //</editor-fold>

    /*
    ------------------------------ Constructors --------------------------------
     */

    //<editor-fold desc="Constructors">
    /**
     * This Constructor creates a visual board, with the given fields.
     * @param fields The list of Field's as Field[]
     */
    public Gui ( Field[] fields ) {

        // Initialize Player ArrayList
        this.players = new ArrayList<>();

        // Create the GUI_Field array
        this.fields = createFields(fields);

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

        // Create the GUI_Field array
        this.fields = createFields(fields);

        // Set Color
        backgroundColor = Color.GRAY;

        // Start GUI
        gui = new GUI(this.fields, backgroundColor);

        // Create the GUI_Player array
        this.players = createPlayers(players);

        for (GUI_Player player : this.players) { gui.addPlayer(player); }
    }
    //</editor-fold>


    /*
    ------------------------------ Properties ----------------------------------
     */

    /*
    ---------------------------- Public Methods --------------------------------
     */

    /**
     * Shows a message to the players
     * @param message The message to show as String
     */
    public void showMessage (String message) {

        // Show the message in the gui
        gui.showMessage(message);
    }

    /**
     * This method sets a Die on the board with the
     * given facevalue.
     * @param faceValue The value of the face on the Die
     */
    public void setDie (int faceValue) {

        // Set the dice on the board
        gui.setDie(faceValue);
    }

    //<editor-fold desc="User Input">

    /**
     * Gets an Integer from the user in a specified range.
     * @param message The message to inform the user
     * @param min The minimum possible valid Integer
     * @param max The maximum possible valid Integer
     * @return Returns an Integer between min and max
     */
    public int getUserInteger (String message, int min, int max) {

        // Get the Integer and Return
        return gui.getUserInteger(message, min, max);
    }

    /**
     * Getting an Integer from the user, and displays a message.
     * @param message The message to inform the user
     * @return Returns the inputted Integer
     */
    public int getUserInteger (String message) {

        // Get the Integer and Return
        return gui.getUserInteger(message);
    }

    /**
     * This method prompts the user to input a String into
     * a textfield, and returns the inputted String.
     * @param message An informal message to the user.
     * @return Returns the input as a String
     */
    public String getUserString (String message) {

        // Get the String and Return
        return gui.getUserString(message);
    }

    //</editor-fold>

    //<editor-fold desc="Player Methods">
    /**
     * Updates the given player visual balance.
     * @param player The player whos balance will get updated
     * @param newBalance The absolute balance of the player
     */
    public void updatePlayerBalance ( Player player, int newBalance ) {

        // Find the player in the GUI_Player list
        GUI_Player playerToUpdate = findPlayer(player);

        // Update the visual balance for the player
        playerToUpdate.setBalance(newBalance);
    }

    /**
     * This method moves the given player to the field
     * according to the index.
     * @param player The player which shall be moved
     * @param theFieldIndex The index of the field in the array
     */
    public void movePlayer ( Player player, int theFieldIndex ) {

        // Find the player in the GUI_Player list
        GUI_Player playerToMove = findPlayer(player);

        // First remove the player from its current field
        for ( GUI_Field field : fields ) {
            field.setCar(playerToMove, false);
        }

        // Move the player on the board
        fields[theFieldIndex].setCar (playerToMove, true);
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

        // Add the player to the gui and set them on the start field
        addGUIPlayer(newPlayer);
        fields[player.getPosition()].setCar(newPlayer, true);
    }
    //</editor-fold>
    
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
    private GUI_Field[] createFields(Field[] fields ) {

        // Create the GUI_Field array
        GUI_Field[] newFields = new GUI_Field[fields.length];

        // Iterate through fields and create GUI_Field for each
        for ( int i=0 ; i < fields.length ; i++ ) {

            if ( fields[i] instanceof Property ) {

                // Create new GUI_Street
                GUI_Street ownable = new GUI_Street(fields[i].getTitle(), "subtext", fields[i].getDescription(),
                        Integer.toString(fields[i].getRent()), fields[i].getColor(), textColor);

                newFields[i] = ownable;
            }

            else if ( fields[i] instanceof Chancefield ) {

                // Create new Field
                GUI_Chance chance = new GUI_Chance(fields[i].getTitle(), "subtext", fields[i].getDescription(),
                                                    fields[i].getColor(), textColor);

                newFields[i] = chance;
            }

            else if ( fields[i] instanceof Prison ) {

                // Create new Field
                GUI_Jail jail = new GUI_Jail();

                newFields[i] = jail;

            }

            else if ( fields[i] instanceof Visiting ) {

                // Create new Field
                GUI_Refuge refuge = new GUI_Refuge();

                newFields[i] = refuge;

            }

            else if ( fields[i] instanceof model.board.fields.Start ) {

                // Create new Field
                GUI_Start start = new GUI_Start(fields[i].getTitle(), "Subtext", fields[i].getDescription(),
                                                fields[i].getColor(), textColor);

                newFields[i] = start;
            }
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

            // Add the created player to the player array and set the player on the start field
            guiPlayers.add(newPlayer);
            fields[players.get(i).getPosition()].setCar(newPlayer, true);
        }

        // Return the GUI_Player array
        return guiPlayers;
    }
}
