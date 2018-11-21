package model.board;
import model.board.Field;
import model.board.fields.*;

import java.awt.*;

public class Board {


    /*
    -------------------------- Fields --------------------------
     */

    private Field[] board;


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

        board[0] = new Start(1, "Start", "Du er landet på start og har fået 2 ekstra penge", 0);
        board[1] = new Property(2, "Burgerbar", "Du er landet på burgerbaren", 20, Color.BLUE, 200);
        board[2] = new Property(3, "Pizzeria", "Du er landet på pizzeriaet", 20, Color.BLUE, 200);
        board[3] = new Chancefield(4, "Chance felt", "Du har chancen ved et kort", 0);
        board[4] = new Property(5, "Slikbutik", "Du er landet på slikbutikken", 10, Color.BLUE, 200);
        /*
        board[5] = new Property(6, "Iskiosk", "Du er landet på iskiosken", "Lyseblå", 1);
        board[6] = new Visiting(7, "På besøg i fængslet", "Du er på besøg i fængslet");
        board[7] = new Property(8, "Museum", "Du er landet på museet", "Pink", 2);
        board[8] = new Property(9, "Bibliotek", "Du er landet på biblioteket", "Pink", 2);
        board[9] = new Chancefield(10, "Chance felt", "Du har chancen med et kort!");
        board[10] = new Property(11, "Skaterpark", "Du er landet på skaterparken", "Orange", 2);
        board[11] = new Property(12, "Swimmingpool", "Du er landet på swimmingpoolen", "Orange", 2);
        board[12] = new Visiting(13, "Gratis parkering", "Du får gratis parkering, tag en pause");
        board[13] = new Property(14, "Spillehal", "Du er landet på spillehallen", "Rød", 3);
        board[14] = new Property(15, "Biograf", "Du er landet på biografen", "Rød", 3);
        board[15] = new Chancefield(16, "Chance felt", "Du har chancen ved et kort");
        board[16] = new Property(17, "Legetøjsbutik", "Du er landet på legetøjsbutikken", "Gul", 3);
        board[17] = new Property(18, "Dyrehandel", "Du er landet på dyrehandlen", "Gul", 3);
        board[18] = new Prison(19, "Gå i fængsel", "Du skal i fængsel og bliver rykket til felt 7");
        board[19] = new Property(20, "Bowlinghal", "Du er landet på bowlinghallen", "Grøn", 4);
        board[20] = new Property(21, "Zoo", "Du er landet på zoologisk have", "Grøn", 4);
        board[21] = new Chancefield(22, "Chance felt", "Du har chancen ved et kort");
        board[22] = new Property(23, "Vandland", "Du er landet på vandland", "Mørkeblå", 5);
        board[23] = new Property(24, "Strandpromenade", "Du er landet på strandpromenaden", "Mørkeblå", 5);
        */

    }

    /*
    ---------------------- Support Methods ----------------------
     */



}
