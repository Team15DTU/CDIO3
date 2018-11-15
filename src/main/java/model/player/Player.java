package model.player;

public class Player {

    /*
     --------- Fields ---------------
      */

    private String name;
    private Account account;
    private boolean hasLost = false;
    private int position;

    /*
     ------- Constructors ------------
      */

    /**
     * Default constructor
     */
    public Player ( String name) {
        // Initialize
        this.name = name;
        account = new Account();
    }

    /**
     * Alternative constructor
     * @param name String
     * @param initialBalance int
     */
    public Player ( String name, int initialBalance ) {
        // Initialize
        this.name = name;
        account = new Account(initialBalance);
    }

    public Player ( String name, int initialBalance, int startingPosition) {
        // Initialize
        this.name = name;
        account = new Account(initialBalance);
        position=startingPosition;

    }

    /*
    -------- Public Methods ----------
     */

    /**
     * Updates the players account with the specified amount
     * @param score The amount which is going to the account as an int
     */
    public void updateScore ( int score ) {
        // Update the account associated with the player
        account.update(score);
    }


    /*
    ------- Support Methods ----------
     */


    /*
     ------ Variable accessible ------
      */

    public Account getAccount()  { return account; }

    public void setAccount(Account account) { this.account = account; }

    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasLost() {return hasLost;}

    public void setHasLost(boolean hasLost) {this.hasLost = hasLost;}

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}
}
