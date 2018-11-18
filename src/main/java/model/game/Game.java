package main.java.model.game;

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

        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Car");
        tokens.add("Dog");
        tokens.add("Cat");
        tokens.add("Boat");

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter name of player " + i);
            String name = scanner.next();
            System.out.println("Now choose a token among ");
            tokens.forEach((a) -> System.out.println(a));
            System.out.println("Press the number corresponding to your desired token ");
            int tokenNo = scanner.nextInt();

            String token = tokens.get(tokenNo);
            Player p = new Player(name, token);
            players.add(p);
            tokens.remove(tokenNo);
        }

        System.out.println("welcome to the game ");

        model.die.Cup cup = new model.die.Cup();

        // turn needs to only take in player and cup
        Turn GameTurn = new Turn();

        int i = 0;
        int k = 0;
        while (!someoneLost) {
            k = i / noOfPlayers;
            Player currPlayer = players.get(k);
            GameTurn.turn(currPlayer, cup);
            i++;
        }

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
