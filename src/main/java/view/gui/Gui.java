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
    private GUI_Player[] players;
    private Color backgroundColor;

    
    /*
    ------------------------------ Constructors --------------------------------
     */

    public Gui (ArrayList<Player> players, Field[] fields) {

        // Create the GUI_Player array
        this.players = createPlayers(players);

        // Create the GUI_Field array


        // Start GUI
        gui = new GUI(this.fields, Color.GRAY);

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
    private GUI_Field[] createProportyFields ( ArrayList<Field> fields ) {

        // Create the GUI_Field array
        GUI_Field[] newFields = new GUI_Field[fields.size()];

        // Iterate through fields and create GUI_Ownable for each
        for ( int i=0 ; i < fields.size() ; i++ ) {

            // Create new GUI_Street
            GUI_Street ownable = new GUI_Street(fields.get(i).getTitle(), "subtext", fields.get(i).getDescription(),
                                                fields.get(i).getLeje(), Color.BLACK, Color.RED);

            newFields[i] = ownable;
        }

        // Return the newly created array
        return newFields;
    }

    /**
     * This method helps the constructor create an Array of GUI_Player's
     * @param players An ArrayList<Player>
     * @return Return an Array of GUI_Player's
     */
    private GUI_Player[] createPlayers (ArrayList<Player> players) {

        // Create the players array as the right size
        GUI_Player[] guiPlayers = new GUI_Player[players.size()];

        // Iterate over the players list and create a GUI_Player for each
        for ( int i=0 ; i < players.size() ; i++ ) {
            GUI_Player newPlayer = new GUI_Player(  players.get(i).getName(),
                                                    players.get(i).getAccount().getBalance(),
                                                    new GUI_Car(Color.RED, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED)
                                                    );

            // Add the created player to the player array
            guiPlayers[i] = newPlayer;
        }

        // Return the GUI_Player array
        return guiPlayers;
    }
}
