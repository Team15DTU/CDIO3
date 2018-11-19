package model.player;

public class Player {

    /*
     --------- Fields ---------------
      */

    private String name;
    private Account account;
    private boolean hasLost;
    private int position;
    private String token;

    /*
     ------- Constructors ------------
      */

    /**
     * Default constructor
     */
    public Player ( String name, String token) {
        // Initialize
        this.name = name;
        this.token = token;
        account = new Account();
    }
  
  public Player ( String name) {
        // Initialize
        this.name = name;  
        account = new Account();
        position = 1;
        hasLost = false;

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
        position = 1;
        hasLost = false;
    }

    public Player ( String name, int initialBalance, int startingPosition ) {
        // Initialize
        this.name = name;
        account = new Account(initialBalance);
        position=startingPosition;
        hasLost = false;
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

    /**
     * Updates the position of the player according to a 24 Field board
     * @param value The amount of positions to move as an int
     */
    public void updatePosition ( int value ) {
        // Update the position with modulus
        position = (position + value) % 24;
    }

    /*
    ------- Support Methods ----------
     */


    /*
     ------ Variable accessible ------
      */

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        //this.model.player.account = account;
    }

    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
  
    public boolean isHasLost() {return hasLost;}

    public void setHasLost(boolean hasLost) {this.hasLost = hasLost;}

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}

}
