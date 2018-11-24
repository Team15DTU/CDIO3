package model.game;

import controller.Controller;
import model.board.Board;
import model.board.Field;
import model.chancecard.Deck;
import model.die.Cup;
import model.player.Player;

import java.util.Scanner;

public class Turn {

    /*
    ------------ Fields ------------------
    */

    Board playingBoard = new Board();
    Field turnField;

    private int rollValue, turnPosition, boardPosition, turnEndingBalance;
    private String fieldName, fieldDescription;

    String input;

    Scanner scanner = new Scanner(System.in);

    /*
    --------- Public Methods ----------
    */

    public void turn(Player player, Cup cup, Controller controller, Deck deck) {
        // Initialize object variable

        // Press to roll message printed and waiting for input

        controller.showMessage("Tryk for at slå med terningene for " + player.getName());
        /*System.out.println("Tryk for at slå med terninger for "+ player.getName());
        input = scanner.nextLine();

        // teksten "exit" afslutter spillet
        if (input.equals("exit")) {
            System.exit(666);
        }
*/
        // Cup is rolled and result is assigned to rollValue
        cup.cupRoll();
        rollValue = cup.getCupValue();

        StringBuilder builderStr = new StringBuilder();
        builderStr.append("Du slog " + rollValue + "\n");

        // Moving Player
        player.updatePosition(rollValue);
        turnPosition=player.getPosition();
        boardPosition = turnPosition+1;

        // Does field action
        turnField=playingBoard.getTurnfield(turnPosition);
        builderStr.append("Og landede på feltet: " + boardPosition+ " - " + turnField.getTitle() + "\n");
        String turnFieldString = builderStr.toString();
        controller.showMessage(turnFieldString);

        // Jeg kan ikke få fieldsDescription ud på GUI
        if (!turnField.getTitle().equals("Chance felt")){
            turnField.action(player);
        } else {
            turnField.action(player,deck);
        }

        turnEndingBalance = player.getAccount().getBalance();
        controller.showMessage("Du har nu: "+turnEndingBalance + " Pengesedler");


        // Check if totalScore is so low that the player lost. If yes, players boolean hasLost is set to true.
        if (turnEndingBalance<= 0) {
            player.setHasLost(true);
        }

        System.out.println();

    }

}
