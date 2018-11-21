package model.board;
import model.board.Field;

public class Board {


    /*
    -------------------------- Fields --------------------------
     */

    Field[] board;


    /*
    ----------------------- Constructor -------------------------
     */

    public Board () {

        board = new Field[24];

        for (int i = 0; i < 24; i++) {

            Field field = new Field(i);

            board[i] = field;

        }
    }

    /*
    ------------------------ Properties -------------------------
     */



    /*
    ---------------------- Public Methods -----------------------
     */

    public void createBoard () {
        Field()

    }

    /*
    ---------------------- Support Methods ----------------------
     */



}
