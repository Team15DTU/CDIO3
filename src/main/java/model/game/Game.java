package model.game;

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

        System.out.println("Welcome to the game of Matador Junior");

        System.out.println("The game can be played by 2 - 4 players. Please enter number of players: ");

        int noOfPlayers = scanner.nextInt();
        while (noOfPlayers < 2 || noOfPlayers > 4) {
            System.out.println("The game can be played by 2 - 4 players. Please enter number of players: ");
            noOfPlayers = scanner.nextInt();
        }

        // this ArrayList contains tokens but they may be changed to obejcts Token instead of Strings


        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Car"); tokens.add("Dog"); tokens.add("Cat"); tokens.add("Boat");

        ArrayList<Player> players = new ArrayList<>();

        //For numbers of players enter name, choose a token, pass these info to new instance of Player in ArrayList

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter name of player " + (i+1));
            String name = scanner.next();
            System.out.println("Now choose a token among ");
            tokens.forEach((a) -> System.out.println(a));
            System.out.println("Press the number corresponding to your desired token ");
            while (true) {
                tokenNo = (scanner.nextInt() - 1);
                if (tokenNo > (-1) && tokenNo < tokens.size()){break;}
            }
            String token = tokens.get(tokenNo);
            Player p = new Player(name, token);
            players.add(p);
            tokens.remove(tokenNo);
        }

        System.out.println("welcome to the game ");

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
            GameTurn.turn(currPlayer, cup);
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

        System.out.println("The winner is "+winner+" with an amount of "+amount);

    }

        public static int getSTARTPOINT () {
            return STARTPOINT;
        }


}
