package model.game;

import controller.Controller;
import model.board.Board;
import model.board.Field;
import model.board.fields.Chancefield;
import model.board.fields.Property;
import model.chancecard.Deck;
import model.die.Cup;
import model.player.Player;

public class Turn {

    /*
    ------------ Fields ------------------
    */

    private Board playingBoard = new Board();
    private int turnEndingBalance;

    private int rollValue, boardPosition;
    private String fieldName, fieldActionText;
    private Field turnField;

    private int turnPosition;

    /*
    --------- Public Methods ----------
    */

    public void turn(Player player, Cup cup, Controller controller, Deck deck) {

        // Initialize object variable

        //  Press to roll message printed and and rolls cup.
        raffleCup(cup, player, controller);

        // Present player with the result of the raffle.
        raffleResult(player,controller);

        turnFieldAction(player,deck,controller,turnPosition);

        updatePlayersGUIBalance(controller, player);




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

    // <editor-folder desc="Methods for raffling">
    /**
     * Askes user to click "OK" to roll the dice
     * @param cup a Cup object containing 1 die with 6 sides
     * @param player a Player object
     * @param controller a Controller object to handle GUI.
     */
    public void raffleCup (Cup cup,Player player, Controller controller) {

    controller.showMessage("Tryk for at slå med terningene for " + player.getName());

    // Cup is rolled and result is assigned to rollValue
    cup.cupRoll();
    rollValue = cup.getCupValue();
    }

    /**
     * Prints the result of the raffle in GUI.
     * Uses method: fieldInfo to information of the field the player lands on.
     * @param player a Player object
     * @param controller a Controller object
     */
    public void raffleResult (Player player, Controller controller) {

        // Player position is update with value from raffleCup
        // and moved on GUI
        player.updatePosition(rollValue);
        controller.movePlayer(player);

        // turnPosition holds value of player position (array starting from 0) on the board
        // boardPosition hold value of players fieldNumber position (field 1 -24) on board
        turnPosition=player.getPosition();
        boardPosition = turnPosition + 1;

        // Gets info of a field at at given position (Array index from 0)
        fieldInfo(turnPosition);

        StringBuilder buildRaffleResult = new StringBuilder();
        buildRaffleResult.append("Du slog " + rollValue + "\n");
        buildRaffleResult.append("Og landede på feltet: " + boardPosition + " - " + fieldName);

        String raffleresultStr = buildRaffleResult.toString();
        controller.showMessage(raffleresultStr);
    }

    // </editor-folder >

    /**
     * Gets information from the fields that the player lands on and set it to local variables
     * @param position Integer of the position i wishes to get information on.
     */
    public  void fieldInfo (int position) {

        turnField=playingBoard.getTurnfield(position);
        fieldName=turnField.getTitle();
        fieldActionText = turnField.getActionText();

    }

    //<editor-fold desc="Action methods for Fields">

    /**
     * Method for action on a field, from a Integer of players position.
     * Calls different method depending of the type of field.
     * @param player a Player object.
     * @param deck a Deck object.
     * @param controller a Controller object.
     * @param position an Integer of the players position for this turn
     */
    public void turnFieldAction (Player player, Deck deck, Controller controller, int position) {

        if (!(turnField instanceof Chancefield)){
            if ((turnField instanceof Property)) {
                // ACtion for fields of type Property.
                propertyFieldAction(player,controller,position);
            } else {
                // Action for fields of types OTHER than Property and Chancefields.
                fieldAction(player,controller,position);
            }
        } else {
            // Action for fields of type Chancefields
            //Does action on new field if chancecard moves player.
            chancefieldFieldAction(player,deck,controller,position);
        }

        updatePlayersGUIBalance(controller, player);

    }


    /**
     * Method for fields of type: Property
     * Contains 2 method: 1 if property have an owner and 1 if it DON'T have an owner.
     * @param player a Player object.
     * @param controller a Controller object.
     * @param position an Integer of the players position for this turn
     */
    public void propertyFieldAction (Player player, Controller controller, int position) {

        Field propertyOnPosition = playingBoard.getTurnfield(position);

        if (propertyOnPosition.getOwner()==null) {
            propertyOnPosition.action(player);
            fieldInfo(position);
            controller.showMessage(fieldActionText);
            updatePlayersGUIBalance(controller,player);
            controller.movePlayer(player);
        } else {
            Player propertyOwner = propertyOnPosition.getOwner();
            propertyOnPosition.action(player);
            fieldInfo(position);
            controller.showMessage(fieldActionText);
            updatePlayersGUIBalance(controller, player, propertyOwner);
        }

    }


    /**
     * Method to fields of type: Chancefields.
     * Mehod does field.action and show chancecard.
     * If player is moved to a new fields, field.action is called on that field.
     * @param player a Player Object.
     * @param deck a deck Object.
     * @param controller a Controller object.
     * @param position an Integer which holds the player position after first roll in this turn.
     */
    public void chancefieldFieldAction (Player player, Deck deck, Controller controller, int position) {
        turnField.action(player,deck);
        fieldInfo(position);
        controller.showMessage(turnField.getActionText());
        showChancecard(controller,deck);
        controller.movePlayer(player);

        int positionAfterChancecard = player.getPosition();
        if (turnPosition != positionAfterChancecard) {
            // Updates fieldInformation so it fits the new position
            fieldInfo(positionAfterChancecard);
            turnFieldAction(player,deck, controller, positionAfterChancecard);
        }
    }


    /**
     * Normal field.action for ANYTHING BUT Property and Chancefields
     * @param player a Player object
     * @param controller a Controller object
     * @param position an Integer which holds the player position of this turn.
     */
    public void fieldAction (Player player, Controller controller, int position) {
        turnField.action(player);
        fieldInfo(position);
        updatePlayersGUIBalance(controller, player);
        controller.showMessage(turnField.getActionText());
        controller.movePlayer(player);
    }

    //</editor-fold>

    // <editor-folder desc="Methods of Player Updates">
    public void updatePlayersGUIBalance(Controller controller, Player player1, Player player2) {
        int player1Balance=player1.getAccount().getBalance();
        int player2Balance= player2.getAccount().getBalance();
        controller.updatePlayerBalance(player1,player1Balance);
        controller.updatePlayerBalance(player2,player2Balance);

    }

    public void updatePlayersGUIBalance(Controller controller, Player player1) {
        int player1Balance=player1.getAccount().getBalance();
        controller.updatePlayerBalance(player1,player1Balance);

    }

    // </editor-folder>

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
