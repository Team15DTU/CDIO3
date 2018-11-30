package model.game;

import controller.Controller;
import model.board.Board;
import model.board.Field;
import model.chancecard.Card;
import model.chancecard.Deck;
import model.chancecard.cards.MovingRel;
import model.die.Cup;
import model.player.Player;

public class Turn {

    /*
    ------------ Fields ------------------
    */

    private Board playingBoard = new Board();
    private int playerBalance;

    private int rollValue, boardPosition;
    private String fieldName, fieldActionText;
    private Field turnField;

    private int prePosition, turnPosition, postPosition;


    /*
    --------- Public Methods ----------
    */

    public void turn(Player player, Cup cup, Controller controller, Deck deck) {

        // Initialize object variable
        // TODO: Kan være der er nogle variable der skal rykkes her ned.

        // Checks if player is on Prison and has to pay to get out.
        checkIfInPrison(player,controller);

        // Checks of player is fallit and sets player as loser if true.
        checkIfFallitWMessage(player,controller, "Du har ikke flere penge tilbage og erklæres fallit");

        //  Press to roll message printed and and rolls cup.
        raffleCup(cup, player, controller);

        // Present player with the result of the raffle
        // Checks if player passes start and gives 2 player 2 "pengesedler" if true
        raffleResult(player,controller);

        // Does action method on the respective field,
        // and does all the actions on new field of player is moved as a result of a field.Action.
        turnFieldAction(player,deck,controller,turnPosition);

        // Updates player score on GUI. Is already done in turnFieldAction but better save than sorry.
        updatePlayersGUIBalance(controller, player);

        // Check if totalScore is so low that the player lost.
        // If yes, players boolean hasLost is set to true and Player score on GUI is set to 0.
        checkIfFallit(player,controller);

        // Check balance is
        printBalance(player,controller);

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
        // Needs to check if player.hasLost is true,
        // as player could go to 0 when paying to get out of Prison in beginning of turn.
        if (!player.isHasLost()) {

            controller.showMessage("Tryk for at slå med terningene for " + player.getName());

            // Cup is rolled and result is assigned to rollValue
            cup.cupRoll();
            rollValue  = cup.getCupValue();
        }
    }

    /**
     * Prints the result of the raffle in GUI.
     * Uses method: updateFieldInfo to information of the field the player lands on.
     * @param player a Player object
     * @param controller a Controller object
     */
    public void raffleResult (Player player, Controller controller) {
        // Needs to check if player.hasLost is true,
        // as player could go to 0 when paying to get out of Prison in beginning of turn.
        if (!player.isHasLost()) {
            // Player position is update with value from raffleCup
            // and moved on GUI
            int prePosition = player.getPosition();
            player.updatePosition(rollValue);

            // turnPosition holds value of player position (array starting from 0) on the board
            // boardPosition hold value of players fieldNumber position (field 1 -24) on board
            turnPosition = player.getPosition();
            boardPosition = turnPosition + 1;

            controller.showMessage("Du slog " + rollValue + "\n");
            movingPlayerForwardGUI(player, controller, prePosition,turnPosition);

            // Gets info of a field at at given position (Array index from 0)
            updateFieldInfo(turnPosition);

            StringBuilder buildRaffleResult = new StringBuilder();

            checkIfPassedStart(prePosition,turnPosition,player, controller, buildRaffleResult,"Du har paseret Start og modtog 2 pengesedler.\n");

            buildRaffleResult.append("Og landede på feltet: " + boardPosition + " - " + fieldName);

            String raffleresultStr = buildRaffleResult.toString();
            controller.showMessage(raffleresultStr);
        }
    }

    // </editor-folder >

    /**
     * Gets information from the fields that the player lands on and set it to local variables
     * @param position Integer of the position i wishes to get information on.
     */
    public  void updateFieldInfo(int position) {

        turnField=playingBoard.getTurnfield(position);
        boardPosition = turnField.getFieldNumber();
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
        // Needs to check if player.hasLost is true,
        // as player could go to 0 when paying to get out of Prison in beginning of turn.
        if (!player.isHasLost()) {
            if (!(turnField.getFieldType().equals("Chancefield"))) {
                if ((turnField.getFieldType().equals("Property"))) {
                    // ACtion for fields of type Property.
                    propertyFieldAction(player, controller, position);
                } else {
                    // Action for fields of types OTHER than Property and Chancefields.
                    fieldAction(player, controller, position);
                }
            } else {
                // Action for fields of type Chancefields
                //Does action on new field if chancecard moves player.
                TESTchancefieldFieldAction(player, deck, controller, position);
            }

            updatePlayersGUIBalance(controller, player);
        }

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
            updateFieldInfo(position);
            controller.showMessage(fieldActionText);
            updatePlayersGUIBalance(controller,player);
            // Skal ikke bruges: controller.movePlayer(player);
        } else {
            Player propertyOwner = propertyOnPosition.getOwner();
            propertyOnPosition.action(player);
            updateFieldInfo(position);
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
    public void WORKINGchancefieldFieldAction(Player player, Deck deck, Controller controller, int position) {
        prePosition = player.getPosition();
        turnField.action(player,deck);
        updateFieldInfo(position);
        postPosition = player.getPosition();
        controller.showMessage(turnField.getActionText());
        showChancecard(controller,deck);
        movingPlayerGUI(player,controller,prePosition,postPosition);

        if (turnPosition != postPosition) {
            // Updates fieldInformation so it fits the new position
            updateFieldInfo(postPosition);
            controller.showMessage("Du bliver rykket til feltet: " + boardPosition + " - " + fieldName);
            turnFieldAction(player,deck, controller, postPosition);
        }
    }

    /**
     * Method to fields of type: Chancefields.
     * Mehod does field.action and show chancecard.
     * If player is moved to a new fields, field.action is called on that field.
     * Checks if chancecard action moves player passed start.
     * @param player a Player Object.
     * @param deck a deck Object.
     * @param controller a Controller object.
     * @param position an Integer which holds the player position after first roll in this turn.
     */
    public void TESTchancefieldFieldAction(Player player, Deck deck, Controller controller, int position) {
        StringBuilder builderChancefield = new StringBuilder();

        Card movingRelCard = deck.getChanceDeck().get(0);
        String cardTypeOnFirstCardInDeck = movingRelCard.getCardType();


        if (cardTypeOnFirstCardInDeck.equals("movingRel")) {
            int movementRel= ((MovingRel) movingRelCard).getMovementRel();
            prePosition = player.getPosition();
            turnField.action(player,deck);
            updateFieldInfo(position);
            postPosition = player.getPosition();
            controller.showMessage(fieldActionText);
            showChancecard(controller,deck);
            if ( movementRel<0) {
                movingPlayerBackwardGUI(player, controller,prePosition,postPosition);
            } else {
                movingPlayerForwardGUI(player, controller, prePosition, postPosition);
            }

            // Make sure that negative movement doesn't count as "passedStart"
           if (((Math.abs(movementRel)+postPosition>23)))  {

                checkIfPassedStart(prePosition, postPosition, player, controller, builderChancefield,
                        "Du har paseret Start og modtog 2 pengesedler.\n");
            }


        } else {
            prePosition = player.getPosition();
            turnField.action(player,deck);
            updateFieldInfo(position);
            postPosition = player.getPosition();
            controller.showMessage(fieldActionText);
            showChancecard(controller,deck);
            updatePlayersGUIBalance(controller,player);
            movingPlayerForwardGUI(player,controller,prePosition,postPosition);

            checkIfPassedStart(prePosition,postPosition,player,controller,builderChancefield,
                    "Du har paseret Start og modtog 2 pengesedler.\n");

        }

        if (turnPosition != postPosition) {
            // Updates fieldInformation so it fits the new position
            updateFieldInfo(postPosition);
            builderChancefield.append("Du bliver rykket til feltet: " + boardPosition + " - " + fieldName);
            String passedStartInChancecard = builderChancefield.toString();
            controller.showMessage(passedStartInChancecard);

            // controller.showMessage("Du bliver rykket til feltet: " + postPosition + " - " + fieldName);
            turnFieldAction(player,deck, controller, postPosition);
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
        updateFieldInfo(position);
        updatePlayersGUIBalance(controller, player);
        controller.showMessage(turnField.getActionText());
        controller.movePlayer(player);
    }

    //</editor-fold>

    // <editor-folder desc="Methods of GUI Player Updates">
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


    public void movingPlayerGUI (Player player, Controller controller, int prePosition, int finalPosition) {
        if (prePosition<=finalPosition) {
            movingPlayerForwardGUI(player,controller,prePosition,finalPosition);
        } else {
            movingPlayerBackwardGUI(player, controller, prePosition, finalPosition);
        }


    }


    public void movingPlayerBackwardGUI(Player player, Controller controller, int prePosition, int finalPosition) {

        if (prePosition<finalPosition && ((finalPosition-prePosition)+finalPosition>=24)) {

            for (int i = prePosition - 1; i >= 0; i--) {
                try {
                    Thread.sleep(500);
                    controller.movePlayer(player, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = playingBoard.getBoard().length - 1; i >= finalPosition; i--) {
                try {
                    Thread.sleep(500);
                    controller.movePlayer(player, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {

            for (int i = prePosition - 1; i >= finalPosition; i--) {
                try {
                    Thread.sleep(500);
                    controller.movePlayer(player, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public void movingPlayerForwardGUI(Player player, Controller controller, int prePosition, int finalPosition) {
        if (prePosition>finalPosition) {
            for (int i = prePosition+1; i<playingBoard.getBoard().length; i++){
                try {
                    Thread.sleep(500);
                    controller.movePlayer(player, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            for (int i = 0; i<=finalPosition; i++) {
                try {
                    Thread.sleep(500);
                    controller.movePlayer(player, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = prePosition + 1; i <= finalPosition; i++) {
                try {
                    Thread.sleep(500);
                    controller.movePlayer(player, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    // </editor-folder>

    // <editor-folder desc="Methods on Player" >

    /**
     * Method check if player balance is 0 or below. If yes, player is declared "fallit"
     * Else player.score is printed
     * @param player a Player object.
     * @param controller a Controller object.
     */
    public void printBalance(Player player, Controller controller) {

        playerBalance = player.getAccount().getBalance();

        if(player.isHasLost()) {
            controller.showMessage("Du har ikke flere penge tilbage og erklæres fallit");
            controller.updatePlayerBalance(player,0);
        } else {
            controller.showMessage("Du har nu: " + playerBalance + " Pengesedler");
            controller.updatePlayerBalance(player, playerBalance);
        }
    }

    /**
     * Checks if player is on Prison. Is yes (player.isInPrison(true) player has to pay to get out of Prison
     * @param player a Player object.
     * @param controller a Controller object.
     */
    public void checkIfInPrison (Player player, Controller controller) {
        String playerName = player.getName();
        String prisonMessage = "Hov hov hov " + playerName + " du sidder i fængsel! \n"
                + "Du betaler 1 pengeseddel for at komme ud af fængslet og kan spille videre";

        if (player.isInPrison()) {
            controller.showMessage(prisonMessage);
            player.updateScore(-1);
            player.setInPrison(false);
            controller.updatePlayerBalance(player, player.getAccount().getBalance());
        }
    }

    /**
     * Checks if players is fallit (score is 0 or below).
     * Sets player.hasLost till true of player is fallit.
     * @param player a Player object.
     * @param controller a Controller object
     * @param fallitMessange message to be printed if fallit.
     */
    public void checkIfFallitWMessage (Player player, Controller controller, String fallitMessange) {
        int playerBalance = player.getAccount().getBalance();
        if(playerBalance <= 0) {
            player.setHasLost(true);
            controller.showMessage(fallitMessange);
            controller.updatePlayerBalance(player,0);
        }
    }

    /**
     * Checks if players is fallit (score is 0 or below).
     * Sets player.hasLost till true of player is fallit.
     * @param player a Player object.
     * @param controller a Controller object
     */
    public void checkIfFallit (Player player, Controller controller) {
        int playerBalance = player.getAccount().getBalance();
        if(playerBalance <= 0) {
            player.setHasLost(true);
            controller.updatePlayerBalance(player,0);
        }
    }

    public void checkIfPassedStart (int prePosition, int postPosition,Player player, Controller controller, StringBuilder stringBuilder, String builderString) {
/*
        if (prePosition>18 && prePosition<23 && postPosition>=0 && postPosition<6 ) {

            if(!(postPosition+prePosition>=23)) {
                stringBuilder.append(builderString);
                player.updateScore(2);
                updatePlayersGUIBalance(controller, player);
            }

        }
*/


        if (prePosition> postPosition && !player.isInPrison()  ) {
   //         if((postPosition+prePosition>=23)) {
                stringBuilder.append(builderString);
                player.updateScore(2);
                updatePlayersGUIBalance(controller, player);
   //         }
        }


    }

    // </editor-folder >


    public void showChancecard (Controller controller, Deck deck) {
        String chanceActionText = deck.getChanceDeck().get(deck.getChanceDeck().size()-1).getDescription();
        controller.setAndDisplayChanceCard(chanceActionText);
    }

}
