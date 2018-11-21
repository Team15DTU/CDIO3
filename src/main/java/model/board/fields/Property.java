package model.board.fields;

import model.board.Field;

public class Property extends Field {


    /*
    -------------------------- Fields --------------------------
     */

    private int fieldNumber;
    private String title;
    private String description;
    private int cost;
    private int rent;

    /*
    ----------------------- Constructor -------------------------
     */

    public Property (int fieldNumber, String title, String description, int cost, int rent) {

        this.fieldNumber=fieldNumber;
        this.title=title;
        this.description=description;
        this.cost=cost;
        this.rent=rent;

    }

    /*
    ------------------------ Properties -------------------------
     */

    public int getCardNumber() {return fieldNumber;}

    public void setCardNumber(int cardNumber) {this.fieldNumber = fieldNumber;}


    public String getTitle() {        return title;    }

    public void setTitle(String title) {        this.title = title;    }

    public String getDescription() {        return description;    }

    public void setDescription(String description) {        this.description = description;    }

    public int getCost() {        return cost;    }

    public void setCost(int cost) {        this.cost = cost;    }

    public int getRent() {        return rent;    }

    public void setRent(int rent) {        this.rent = rent;    }

    /*
    ---------------------- Public Methods -----------------------
     */



    /*
    ---------------------- Support Methods ----------------------
     */



}
