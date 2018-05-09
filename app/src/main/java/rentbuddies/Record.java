package com.example.dombalj.rentbuddies;

import java.util.Date;

/**
 * Created by dombalj on 3/15/18.
 */

public class Record {


    private int id;
    private String date;
    private double amount;



    public Record(int id, String d, double amount) {
        this.date = d;
        this.amount = amount;
    }


    public void setID(int id) {
        this.id = id;
    }

    public void setDate(String d) {
        this.date = d;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }




    public String getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getID() {
        return this.id;
    }
}
