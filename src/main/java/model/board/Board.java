package model.board;
import model.board.Field;
import model.board.fields.Chancefield;
import model.board.fields.Property;
import model.board.fields.Start;
import model.board.fields.Visiting;

import java.awt.*;

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
        createBoard();

    }

    /*
    ------------------------ Properties -------------------------
     */



    /*
    ---------------------- Public Methods -----------------------
     */

    public void createBoard () {

        board[1] = new Start(1, "Start", "Du er landet på start og har fået 2 ekstra penge");
        board[2] = new Property(2, "Burgerbar", "Du er landet på burgerbaren", "Brun",1);
        board[3] = new Property(3, "Pizzeria", "Du er landet på pizzeriaet", "Brun", 1);
        board[4] = new Chancefield(4, "Chance felt", "Du har chancen ved et kort");
        board[5] = new Property(5, "Slikbutik", "Du er landet på slikbutikken", "Lyseblå", 1);
        board[6] = new Property();
        board[7] = new Visiting();
        board[8] = new Property();
        board[9] = new Property();
        board[10] = new Chancefield();
        board[11] = new Property();
        board[12] = new Property();
        board[13] = new Property();
        board[14] = new Property();
        board[15] = new Property();
        board[16] = new Chancefield();
        board[17] = new Property();
        board[18] = new Property();
        board[19] = new Visiting();
        board[20] = new Property();
        board[21] = new Property();
        board[22] = new Chancefield();
        board[23] = new Property();
        board[24] = new Property();

    }

    /*
    ---------------------- Support Methods ----------------------
     */



}
