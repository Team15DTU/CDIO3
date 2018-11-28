package model.board;
import model.board.Field;
import model.board.fields.*;

import java.awt.*;

public class Board {


    /*
    -------------------------- Fields --------------------------
     */

    private Field[] board;
    private int totalFieldsOnBoard;


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

    public Field[] getBoard() {
        return board;
    }

    public void setBoard(Field[] board) {
        this.board = board;
    }

    public int getTotalFieldsOnBoard() {
        return totalFieldsOnBoard;
    }

    public void setTotalFieldsOnBoard(int totalFieldsOnBoard) {
        this.totalFieldsOnBoard = totalFieldsOnBoard;
    }

/*
    ---------------------- Public Methods -----------------------
     */

    public void createBoard () {

        addStart(1, "Start", "Du er landet på start og har fået 2 ekstra penge", 20, Color.GREEN);
        addProperty(2, "Burgerbar", "Du er landet på burgerbaren", 1, new Color(205,133,63));
        addProperty(3, "Pizzeria", "Du er landet på pizzeriaet", 1, new Color(205,133,63));
        addChancefield(4, "Chance felt", "Du har chancen ved et kort", 0, Color.WHITE);
        addProperty(5, "Slikbutik", "Du er landet på slikbutikken", 1, new Color( 137, 207, 240));
        addProperty(6, "Iskiosk", "Du er landet på iskiosken",1, new Color( 137, 207, 240));
        addPrison(7, "På besøg i fængslet", "Du er på besøg i fængslet",0,Color.GRAY);
        addProperty(8, "Museum", "Du er landet på museet",2,Color.pink);
        addProperty(9, "Bibliotek", "Du er landet på biblioteket", 2, Color.pink);
        addChancefield(10, "Chance felt", "Du har chancen med et kort!",0,Color.white);
        addProperty(11, "Skaterpark", "Du er landet på skaterparken", 2, Color.orange);
        addProperty(12, "Swimmingpool", "Du er landet på swimmingpoolen", 2, Color.orange);
        addVisitin(13, "Gratis parkering", "Du får gratis parkering, tag en pause",0,Color.GRAY  );
        addProperty(14, "Spillehal", "Du er landet på spillehallen", 3, Color.red);
        addProperty(15, "Biograf", "Du er landet på biografen", 3, Color.red);
        addChancefield(16, "Chance felt", "Du har chancen ved et kort",0,Color.white);
        addProperty(17, "Legetøjsbutik", "Du er landet på legetøjsbutikken", 3, Color.yellow);
        addProperty(18, "Dyrehandel", "Du er landet på dyrehandlen", 3, Color.yellow);
        addPrison(19, "Gå i fængsel", "Du skal i fængsel og bliver rykket til felt 7",0,Color.gray);
        addProperty(20, "Bowlinghal", "Du er landet på bowlinghallen", 4,Color.green);
        addProperty(21, "Zoo", "Du er landet på zoologisk have", 4,Color.green);
        addChancefield(22, "Chance felt", "Du har chancen ved et kort",0,Color.white);
        addProperty(23, "Vandland", "Du er landet på vandland", 5,new Color( 0, 128, 255));
        addProperty(24, "Strandpromenade", "Du er landet på strandpromenaden", 5, new Color( 0, 128, 255));

        totalFieldsOnBoard= board.length;

    }

    /*
    ---------------------- Support Methods ----------------------
     */

    public void addProperty (int fieldNumber, String title, String description, int rent, Color color) {
        int index = fieldNumber-1;
        board[index] = new Property(fieldNumber,title,description,rent,color);
    }

    public void addChancefield ( int fieldNumber, String title, String description, int rent, Color color) {
        int index = fieldNumber-1;
        board[index] = new  Chancefield(fieldNumber,title,description,rent,color);
    }

    public void addPrison(int fieldNumber, String title, String description, int rent, Color color) {
        int index = fieldNumber-1;
        board[index] = new Prison(fieldNumber,title,description,rent,color);

    }
    public void addStart(int fieldNumber, String title, String description, int rent, Color color) {
        int index = fieldNumber-1;
        board[index] = new Start(fieldNumber,title,description,rent,color);

    }

    public void addVisitin(int fieldNumber, String title, String description, int rent, Color color) {
        int index = fieldNumber-1;
        board[index] = new Visiting(fieldNumber,title,description,rent,color);

    }

    public Field getTurnfield(int turnPosition) {
        Field turnField;
        turnField = board[turnPosition];

        return turnField;
    }
}
