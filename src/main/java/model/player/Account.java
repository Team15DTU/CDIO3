package model.player;

public class Account {

    /*
     ------------ Fields ------------------
      */
    private int balance;

    /*
    ----------- Constructors --------------
     */

    /**
     * Primary Constructor
     */
    public Account () {
        // Set initial balance to 0
        balance = 0;
    }

    /**
     * Constructs an Account with an initial balance
     * @param balance int
     */
    public Account (int balance) {
        this.balance = balance;
    }

    /*
    ------------ Properties ------------
     */

    public int getBalance () { return balance; }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /*
     --------- Public Methods ----------
      */

    public void update(int points) {
        // update points to balance
        balance += points;
    }
}

