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

    private int rollValue, turnPosition, boardPosition;
    private String fieldName, fieldDescription;

    String input;

    Scanner scanner = new Scanner(System.in);

    /*
    --------- Public Methods ----------
    */

    public void turn(Player player, Cup cup, Controller controller, Deck deck) {


        // Initialize object variable
        int turnEndingBalance=player.getAccount().getBalance();
        String chanceActionText;

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

        // Moves player on GUI
        movingPlayer(player,controller);

        /*
        turnPosition=player.getPosition();
        controller.movePlayer(player);
        */

        // Placement on board.
        boardPosition = turnPosition+1;

        // Does field action
        turnField=playingBoard.getTurnfield(turnPosition);
        fieldName=turnField.getTitle();
        fieldDescription =turnField.getDescription();
        builderStr.append("Og landede på feltet: " + boardPosition+ " - " + fieldName + "\n");

        // Jeg kan ikke få fieldsDescription ud på GUI
        turnField.getDescription();
        if (!turnField.getTitle().equals("Chance felt")){
            turnField.action(player);
            builderStr.append(fieldDescription+"\n");

        } else {
            turnField.action(player,deck);
            chanceActionText = deck.getChanceDeck().get(deck.getChanceDeck().size()-1).getDescription();
            controller.setAndDisplayChanceCard(chanceActionText);
        }

        resultOfTurn(player, controller, turnPosition);


        String turnFieldString = builderStr.toString();
        controller.showMessage(turnFieldString);

        turnEndingBalance = player.getAccount().getBalance();
        if(turnEndingBalance<=0) {
            controller.showMessage("Du har ikke flere penge tilbage og erklæres fallit");
            controller.updatePlayerBalance(player,turnEndingBalance);
        } else {
            controller.showMessage("Du har nu: " + turnEndingBalance + " Pengesedler");
            controller.updatePlayerBalance(player,turnEndingBalance);
        }


        // Check if totalScore is so low that the player lost. If yes, players boolean hasLost is set to true.
        if (turnEndingBalance<= 0) {
            player.setHasLost(true);
        }

        System.out.println();

    }

    /*
    ----------- SUPPORT METHODS --------------
     */

    public void movingPlayer (Player player, Controller controller) {
        turnPosition=player.getPosition();
        controller.movePlayer(player);
    }

    public void resultOfTurn (Player player, Controller controller, int position) {
        controller.movePlayer(player);
        controller.updatePlayerBalance(player,position);
    }

}
