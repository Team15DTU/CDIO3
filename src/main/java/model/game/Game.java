package main.java.model.game;

import model.player.Player;

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

    /*
    -------- Public Methods -------
     */
    /**
     * This method runs the game with all logic and rules from the beginning till the announcing of the winner.
     */

    public void launch () {

        System.out.println("Welcome to the game of Matador Junior");

        System.out.println("The game can be played by 2 - 4 players. Please enter number of players: ");

        int noOfPlayers = scanner.nextInt();
        while (noOfPlayers < 2 || noOfPlayers > 4) {
            System.out.println("The game can be played by 2 - 4 players. Please enter number of players: ");
            noOfPlayers = scanner.nextInt();
        }

        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Car"); tokens.add("Dog"); tokens.add("Cat"); tokens.add("Boat");

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter name of player "+i);
            String name = scanner.next();
            System.out.println("Now choose a token among ");
            tokens.forEach((a)-> System.out.println(a));
            System.out.println("Press the number corresponding to your desired token ");
            int tokenNo = scanner.nextInt();



            Player p = new Player(name, STARTPOINT);
            players.add(p);
        }




        System.out.println(Reader.print("enterName") + Reader.print("player1"));
        String navn = scanner.nextLine();
        Player player1 = new Player(navn, STARTPOINT);
        String player1Name = player1.getName();
        System.out.print(Reader.print("hi") + " " + player1Name + Reader.print("hiPlayer"));
        System.out.println(" " + STARTPOINT + Reader.print("pointName"));

        System.out.println(Reader.print("enterName") + Reader.print("player2"));
        navn = scanner.nextLine();
        Player player2 = new Player(navn, STARTPOINT);
        String player2Name = player2.getName();
        System.out.print(Reader.print("hi") + " " + player2Name + Reader.print("hiPlayer"));
        System.out.println(" " + STARTPOINT + Reader.print("pointName"));
        System.out.println();

        System.out.println(Reader.print("welcomeToGame"));

        Cup cup = new Cup();

        // turn needs to only take in player and cup
        Turn GameTurn = new Turn();

        while (!player1.isHasWon() && !player2.isHasWon()) {
            GameTurn.turn(player1, cup);
            if (!player1.isHasWon()) {
                GameTurn.turn(player2, cup);
            }
        }


        if (player1.getAccount().getBalance() > player2.getAccount().getBalance()) {
            System.out.println(Reader.print("congrats") + " " +player1.getName());
            System.out.print(Reader.print("theEnding"));
        } else {
            System.out.println(Reader.print("congrats") + " " + player2.getName());
            System.out.print(Reader.print("theEnding"));
        }
    }

    public static int getSTARTPOINT() {return STARTPOINT;}

    public static int getWINNINGPOINTS() {return WINNINGPOINTS;}
}
