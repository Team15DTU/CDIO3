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

        // Start GUI
        gui = new GUI(this.fields, Color.GRAY);

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

        // Start GUI
        gui = new GUI(this.fields, Color.GRAY);
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
    
    /*
    ----------------------------- Support Methods ------------------------------
     */

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