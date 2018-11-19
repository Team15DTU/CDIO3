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

    GUI gui;
    GUI_Field[] fields;
    GUI_Player[] players;
    Color backgroundColor;

    
    /*
    ------------------------------ Constructors --------------------------------
     */

    public Gui (ArrayList<Player> players, Field[] fields) {

        // Create the players array as the right size
        this.players = new GUI_Player[players.size()];


        for ( Player player : players ) {

        }


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
}
