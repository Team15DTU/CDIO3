package model.game;

import controller.Controller;
import model.board.Board;
import model.board.Field;
import model.die.Cup;
import model.player.Player;

import java.util.Scanner;

public class Turn {

    /*
    ------------ Fields ------------------
    */

    Board playingBoard = new Board();
    Field turnField;

    private int rollValue, turnPoint, totalScore;
    private String fieldName, fieldDescription;

    String input;

    Scanner scanner = new Scanner(System.in);

    /*
    --------- Public Methods ----------
    */

    public void turn(Player player, Cup cup, Controller controller) {
        // Initialize object variable

        // Press to roll message printed and waiting for input

        controller.getUserString("Tryk for at slå med terninger for "+ player.getName());

        // Cup is rolled and result is assigned to rollValue
        cup.cupRoll();
        rollValue = cup.getCupValue();
        controller.showMessage("Du slog " + rollValue);

        // Moving Player and does Fields Action.
        controller.movePlayer(player, rollValue);
        turnField=playingBoard.getField(player.getPosition());
        turnField.action(player);

        // Check if totalScore is so low that the player lost. If yes, players boolean hasLost is set to true.
        if (totalScore < 0) {
            player.setHasLost(true);
        }

    }

}
