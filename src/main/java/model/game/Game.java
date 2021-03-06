package model.game;

import controller.Controller;
import model.board.Board;
import model.chancecard.Deck;
import model.player.Player;
import model.die.Cup;

import java.util.ArrayList;

/**
 * @author team15
 * Date: 04-11-2018
 * University: DTU
 */

public class Game {

    /*
    ----------- Fields -----------
    */

    private static int STARTPOINT = 20;
    private final static int STARTINGPOSITION=0;
    private boolean someoneLost = false;


    /*
    -------- Public Methods -------
     */

    /**
     * This method runs the game with all logic and rules from the beginning till the announcing of the winner.
     */

    public void launch() {

        Board playingboard = new Board();
        Controller controller = new Controller(playingboard.getBoard());

        int noOfPlayers = controller.getUserInteger("Spillet kan spilles af 2 - 4 spillere. Hvor mange skal spille med?", 2, 4);

        // Set Starting points from number of players playing the game.
        setStartPointsFromNoOfPlayer(noOfPlayers);

        // this ArrayList contains tokens but they may be changed to obejcts Token instead of Strings

        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Bil"); tokens.add("Racerbil"); tokens.add("UFO"); tokens.add("Traktor");

        ArrayList<Player> players = new ArrayList<>();

        //For numbers of players enter name, choose a token, pass these info to new instance of Player in ArrayList

        for (int i = 0; i < noOfPlayers; i++) {
            String name = controller.getUserString("Indtast navn på spiller " + Integer.toString(i + 1));

            String chosenToken = controller.getUserChoice("Vælg en spillerbrik:", tokens);
            for (int j = 0; j < tokens.size(); j++) {
                if (tokens.get(j).equals(chosenToken)) {
                    tokens.remove(j);

                }
            }
            Player p = new Player(name, chosenToken, STARTPOINT, STARTINGPOSITION);
            players.add(p);
            controller.showMessage("Du valgt: " + chosenToken);
        }

        controller.showMessage("Velkommen til Monopoly Junior");
        controller.addPlayers(players);

        Cup cup = new Cup(1,6);
        Deck chancedeck = new Deck(1);
        chancedeck.shuffleDeck(10);

        // turn needs to only take in player and cup
        Turn GameTurn = new Turn();

        //As long as no one has lost loop through players list and do a turn
        int i = 0;
        int k;
        while (!someoneLost) {
            k = i % noOfPlayers;
            Player currPlayer = players.get(k);
            GameTurn.turn(currPlayer, cup, controller,chancedeck);
            if (currPlayer.isHasLost()){
                someoneLost=true;
            }
            i++;
        }

        //When someone lost, find the player with the biggest balance and crown as winner

        controller.showMessage("Der er en spiller der er gået fallit og spillet er slut.");
        controller.showMessage("Vi har talt pengene op og har en fundet en vinder....\n");

        String winningResult= findWinner(players,noOfPlayers);
        announceWinner(winningResult,controller);

    }

    /*
    ------------------ Properties --------------------
     */


        public static int getSTARTPOINT () {
            return STARTPOINT;
        }

    /*
    ---------------- Support Method --------------------
     */

    private String findWinner (ArrayList<Player> players, int numberOfPlayers) {
            //When someone lost, find the player with the biggest balance and crown as winner

            int amount = 0;
            Player win = players.get(0);
            String winner = "noone";
            for (int j = 0; j < numberOfPlayers; j++) {
                Player currPlayer = players.get(j);
                if (currPlayer.getAccount().getBalance() > amount) {
                    amount = currPlayer.getAccount().getBalance();
                    winner = currPlayer.getName();
                    win = currPlayer;
                }
                else if (currPlayer.getAccount().getBalance() == amount) {

                    if (win.getTotalPropertyValue()>currPlayer.getTotalPropertyValue()) {
                        winner = win.getName();
                    } else if (win.getTotalPropertyValue()<currPlayer.getTotalPropertyValue()){
                        winner = currPlayer.getName();
                    } else {
                        winner = currPlayer.getName() + " og " + winner;
                    }
                }
            }

            return "VINDEREN ER: \n \n" + winner + "\n \n" + "TILLYKKE!!!!";
        }

    private void announceWinner (String winnerResult, Controller controller) {

            controller.setChanceCard( winnerResult);
            controller.displayChanceCard();
            controller.startWinnerMode();

        }

    public void setStartPointsFromNoOfPlayer (int totalNoOfPlayer) {
            switch (totalNoOfPlayer) {
                case 2:
                    STARTPOINT = 20;
                    break;
                case 3:
                    STARTPOINT = 18;
                    break;
                case 4:
                    STARTPOINT = 16;
                default:
                    break;
            }
        }
}
