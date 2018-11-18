package main.java.model.game;

import java.util.Scanner;

public class Turn {

    /*
    ------------ Fields ------------------
    */

    private int rollValue, turnPoint, totalScore;
    private String fieldName, fieldDescription;

    String input;

    Scanner scanner = new Scanner(System.in);

    /*
    --------- Public Methods ----------
    */

    public void turn(model.player.Player player, model.die.Cup cup) {
        // Initialize object variable

        // Press to roll message printed and waiting for input
        System.out.println("Press to roll for "+ player.getName());
        input = scanner.nextLine();

        // teksten "exit" eller "sluk" afslutter spillet
        if (input.equals("exit")) {
            System.exit(666);
        }

        // Cup is rolled and result is assigned to rollValue
        cup.cupRoll();
        rollValue = cup.getCupValue();

        // rollValue input into fieldsSwitch and assigning fieldPoint, fieldName and fieldDescription


        // turnPoint is added to the players current balance and the new balance is assigned to totalScore
        player.updateScore(turnPoint);
        totalScore = player.getAccount().getBalance();

        // Result of your turn is printed out.
        System.out.println("You rolled" + rollValue);

        // Check if totalScore is enough to win. If yes, players boolean hasWon is set to true.
        if (totalScore < 0) {
            player.setHasLost(true);
        }

    }

}
