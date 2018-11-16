package main.java.model.game;

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

    final static int STARTPOINT = 1000;
    final static int WINNINGPOINTS = 3000;

    /*
    -------- Public Methods -------
     */
    /**
     * This method runs the game with all logic and rules from the beginning till the announcing of the winner.
     */

    public void launch () {

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
