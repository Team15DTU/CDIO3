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

    final static int STARTPOINT = 12000;
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



        int noOfPlayers = controller.getUserInteger("The game can be played by 2 - 4 players. Please enter number of players", 2, 4);

        // this ArrayList contains tokens but they may be changed to obejcts Token instead of Strings


        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Car"); tokens.add("Dog"); tokens.add("Cat"); tokens.add("Boat");

        ArrayList<Player> players = new ArrayList<>();

        //For numbers of players enter name, choose a token, pass these info to new instance of Player in ArrayList

        for (int i = 0; i < noOfPlayers; i++) {
            String name = controller.getUserString("Enter name of player " + Integer.toString(i+1));
            int j = 1;controller.showMessage("Now choose a token among ");
            for (String t : tokens) {
                controller.showMessage(Integer.toString(j));
                controller.showMessage(t);
                j++;
            }
            tokenNo = controller.getUserInteger("Press the number corresponding to your desired token ", 0, tokens.size());
            System.out.println("Press the number corresponding to your desired token ");
            String token = tokens.get(tokenNo);
            Player p = new Player(name, token);
            players.add(p);
            tokens.remove(tokenNo);
        }

        controller.showMessage("welcome to the game ");

        model.die.Cup cup = new model.die.Cup();
        Deck chancedeck = new Deck(10);

        // turn needs to only take in player and cup
        Turn GameTurn = new Turn();

        //As long as no one has lost loop through players list and do a turn

        int i = 0;
        int k = 0;
        while (!someoneLost) {
            k = i % noOfPlayers;
            Player currPlayer = players.get(k);
            GameTurn.turn(currPlayer, cup, controller);
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


}
