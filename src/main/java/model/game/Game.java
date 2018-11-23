package model.game;

import controller.Controller;
import model.board.Board;
import model.chancecard.Deck;
import model.player.Player;
import model.die.Cup;
import model.player.token.Token;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author team15
 * Date: 04-11-2018
 * University: DTU
 */

public class Game {

    /*
    ----------- Fields -----------
    */

    Scanner scanner = new Scanner(System.in);

    static int STARTPOINT = 20;
    final static int STARTINGPOSITION=0;
    boolean someoneLost = false;
    int tokenNo;

    /*
    -------- Public Methods -------
     */

    /**
     * This method runs the game with all logic and rules from the beginning till the announcing of the winner.
     */

    public void launch() {

        Board playingboard = new Board();
        Controller controller = new Controller(playingboard.getBoard());

        int noOfPlayers = controller.getUserInteger("Spillet kan spilles af 2 - 4 spillere. Hvor mange skal spille med?", 2, 4);

        // Set Starting points from number of players playing the game.
        setStartPointsFromNoOfPlayer(noOfPlayers);

        // this ArrayList contains tokens but they may be changed to obejcts Token instead of Strings


        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Bil"); tokens.add("Racerbil"); tokens.add("UFO"); tokens.add("Traktor");

        ArrayList<Player> players = new ArrayList<>();

        //For numbers of players enter name, choose a token, pass these info to new instance of Player in ArrayList

        for (int i = 0; i < noOfPlayers; i++) {
            String name = controller.getUserString("Indtast navn på spiller " + Integer.toString(i+1));
            StringBuilder str = new StringBuilder();
            str.append("Vælg en spillerbrik: \n");
            int j = 1;
            for (String t : tokens) {
                str.append(Integer.toString(j)+" - ");
                str.append(t+"\n");
                j++;
            }
            str.append("Indtast tallet der passer til den ønskede spillerbrik.");
            String string = str.toString();
            tokenNo = controller.getUserInteger(string, 0, tokens.size());
            tokenNo=tokenNo-1;
            String token = tokens.get(tokenNo);
            Player p = new Player(name, token, STARTPOINT, STARTINGPOSITION);
            players.add(p);
            controller.showMessage("Du valgt: "+tokens.get(tokenNo));
            tokens.remove(tokenNo);
        }

        controller.showMessage("Velkommen til Monopoly Junior");

        Cup cup = new Cup(1,6);
        Deck chancedeck = new Deck(1);

        // turn needs to only take in player and cup
        Turn GameTurn = new Turn();

        //As long as no one has lost loop through players list and do a turn

        int i = 0;
        int k;
        while (!someoneLost) {
            k = i % noOfPlayers;
            Player currPlayer = players.get(k);
            GameTurn.turn(currPlayer, cup, controller);
            if (currPlayer.isHasLost()){
                someoneLost=true;
            }
            i++;
        }

        //When someone lost, find the player with the biggest balance and crown as winner

        int amount = 0;
        String winner = "noone";
        for (int j = 0; j < noOfPlayers; j++) {
            Player currPlayer = players.get(j);
            if (currPlayer.getAccount().getBalance() > amount) {
                amount = currPlayer.getAccount().getBalance();
                winner = currPlayer.getName();
            }
            i++;
        }

        controller.showMessage("The winner is "+winner+" with an amount of "+amount);
    }

        public static int getSTARTPOINT () {
            return STARTPOINT;
        }


        /*
        ---------------- Support Method --------------------
         */

        public void setStartPointsFromNoOfPlayer (int totalNoOfPlayer) {
            switch (totalNoOfPlayer) {
                case 2:
                    STARTPOINT = 20;
                    break;
                case 3:
                    STARTPOINT = 18;
                    break;
                case 4:
                    STARTPOINT = 16;
                default:
                    break;
            }
        }
}
