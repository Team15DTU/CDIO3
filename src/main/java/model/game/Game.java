package model.game;

import controller.Controller;
import model.board.Board;
import model.chancecard.Deck;
import model.player.Player;
import model.die.Cup;

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

    private static int STARTPOINT = 20;
    private final static int STARTINGPOSITION=0;
    private boolean someoneLost = false;
    private int tokenNo;

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
            String name = controller.getUserString("Indtast navn på spiller " + Integer.toString(i + 1));

            String choosenToken = controller.getUserChoice("Vælg en spillerbrik:", tokens);
            for (int j = 0; j < tokens.size(); j++) {
                if (tokens.get(j).equals(choosenToken)) {
                    tokens.remove(j);

                }
            }
            Player p = new Player(name, choosenToken, STARTPOINT, STARTINGPOSITION);
            players.add(p);
            controller.showMessage("Du valgt: " + choosenToken);
        }


        controller.showMessage("Velkommen til Monopoly Junior");
        controller.addPlayers(players);

        Cup cup = new Cup(1,6);
        Deck chancedeck = new Deck(1);
        chancedeck.shuffleDeck(10);

        // turn needs to only take in player and cup
        Turn GameTurn = new Turn();

        //As long as no one has lost loop through players list and do a turn

        int i = 0;
        int k;
        while (!someoneLost) {
            k = i % noOfPlayers;
            Player currPlayer = players.get(k);
            GameTurn.turn(currPlayer, cup, controller,chancedeck);
            if (currPlayer.isHasLost()){
                someoneLost=true;
            }
            i++;
        }

        //When someone lost, find the player with the biggest balance and crown as winner

        int amount = 0;
        Player win = players.get(0);
        String winner = "noone";
        for (int j = 0; j < noOfPlayers; j++) {
            Player currPlayer = players.get(j);
            if (currPlayer.getAccount().getBalance() > amount) {
                amount = currPlayer.getAccount().getBalance();
                winner = currPlayer.getName();
                win = currPlayer;
            }
            else if (currPlayer.getAccount().getBalance() == amount) {

                if (win.getTotalPropertyValue()>currPlayer.getTotalPropertyValue()) {
                    winner = win.getName();
                } else if (win.getTotalPropertyValue()<currPlayer.getTotalPropertyValue()){
                    winner = currPlayer.getName();
                } else {
                    winner = currPlayer.getName() + " and " + winner;
                }
            }
            i++;
        }

        controller.showMessage("Vinderen er "+winner+" med "+amount +" pengesedler");
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
