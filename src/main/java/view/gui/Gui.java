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
