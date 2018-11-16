package main.java.model.game;

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

    public void turn(Player player, Cup cup) {
        // Initialize object variable

        // Press to roll message printed and waiting for input
        System.out.println(Reader.print("rollPress") + " " + player.getName());
        input = scanner.nextLine();

        // teksten "exit" eller "sluk" afslutter spillet
        if (input.equals(Reader.print("exit"))) {
            System.exit(666);
        }

        // Cup is rolled and result is assigned to rollValue
        cup.cupRoll();
        rollValue = cup.getCupValue();

        // rollValue input into fieldsSwitch and assigning fieldPoint, fieldName and fieldDescription
        Fields.fieldsSwitch(rollValue);
        turnPoint = Fields.getFieldPoint();
        fieldName = Fields.getFieldName();
        fieldDescription = Fields.getFieldDescription();

        // turnPoint is added to the players current balance and the new balance is assigned to totalScore
        player.updateScore(turnPoint);
        totalScore = player.getAccount().getBalance();

        // Result of your turn is printed out.
        System.out.println(Reader.print("rolled") + " " + rollValue + Reader.print("landed") + " " + Reader.print(fieldName));
        System.out.println();
        System.out.println(Reader.print(fieldDescription));
        System.out.println(Reader.print("totalScore") + " " + totalScore + Reader.print("pointName"));
        System.out.println();

        // Check if totalScore is enough to win. If yes, players boolean hasWon is set to true.
        if (totalScore > Game.WINNINGPOINTS) {
            player.setHasWon(true);
        }

        // If rollValue is equal to 10 you get an extra turn
        if (rollValue == 10) {
            turn(player, cup);
        }

    }

}
