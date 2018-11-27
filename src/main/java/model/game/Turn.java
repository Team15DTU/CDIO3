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

    private Board playingBoard = new Board();
    private Field turnField;
    private int rollValue, turnPosition, boardPosition;
    private String fieldName, fieldDescription, input;

    Scanner scanner = new Scanner(System.in);

    /*
    --------- Public Methods ----------
    */

    public void turn(Player player, Cup cup, Controller controller, Deck deck) {


        // Initialize object variable
        int turnEndingBalance;

        // Press to roll message printed and waiting for input
        controller.showMessage("Tryk for at slå med terningene for " + player.getName());
        /*System.out.println("Tryk for at slå med terninger for "+ player.getName());
        input = scanner.nextLine();

        // teksten "exit" afslutter spillet
        if (input.equals("exit")) {
            System.exit(666);
        } TODO: Dette er unødvendigt med GUI?
*/
        // Cup is rolled and result is assigned to rollValue
        cup.cupRoll();
        rollValue = cup.getCupValue();

        StringBuilder builderRollAndMove = new StringBuilder();
        builderRollAndMove.append("Du slog " + rollValue + "\n");

        // Moves player on GUI and set player position
        movingPlayer(player,controller, rollValue);

        /* TODO: Rasmus skal dette fixes?
        turnPosition=player.getPosition();
        controller.movePlayer(player);
        */

        // Placement on board.
        boardPosition = turnPosition + 1;

        // Does field action
        turnField=playingBoard.getTurnfield(turnPosition);
        fieldName=turnField.getTitle();
        fieldDescription =turnField.getDescription();
        builderRollAndMove.append("Og landede på feltet: " + boardPosition+ " - " + fieldName + "\n");

        String rollAndMoveDesc = builderRollAndMove.toString();
        controller.showMessage(rollAndMoveDesc);

        StringBuilder builderResult = new StringBuilder();
        if (!turnField.getTitle().equals("Chance felt")){
            turnField.action(player);
            builderResult.append(turnField.getActionText());
            //builderRollAndMove.append(fieldDescription+"\n"); TODO: Er description ikke ret redundant?

        } else {
            turnField.action(player,deck);
            builderResult.append(turnField.getActionText());
            showChancecard(controller,deck);
        }

        turnEndingBalance = player.getAccount().getBalance();
        resultOfTurn(player, controller, turnEndingBalance);

        String turnResult = builderResult.toString();
        controller.showMessage(turnResult);



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

    public void movingPlayer (Player player, Controller controller, int rollValue) {
        player.updatePosition(rollValue);
        turnPosition=player.getPosition();
        controller.movePlayer(player);
    }

    public void resultOfTurn (Player player, Controller controller, int turnBalance) {
        controller.movePlayer(player);
        controller.updatePlayerBalance(player, turnBalance);
    }
    public void showChancecard (Controller controller, Deck deck) {
        String chanceActionText = deck.getChanceDeck().get(deck.getChanceDeck().size()-1).getDescription();
        controller.setAndDisplayChanceCard(chanceActionText);
    }

    public void actionAsResultOfChancecard (Player player) {
        int positionAfterChancecard = player.getPosition();

        if (positionAfterChancecard != turnPosition) {
            Field newFieldOfChancecard = playingBoard.getTurnfield(player.getPosition());
            newFieldOfChancecard.action(player);
        }
    }
}
