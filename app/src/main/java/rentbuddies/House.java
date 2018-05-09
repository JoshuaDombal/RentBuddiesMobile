package com.example.dombalj.rentbuddies;


/**
 * Created by dombalj on 3/13/18.
 */



public class House {

    private String houseName;
    private double housePrice;
    private int numRoomates;



    public House(String newHouseName, double newHousePrice, int newNumRoomates) {
        houseName = newHouseName;
        housePrice = newHousePrice;
        numRoomates = newNumRoomates;
    }


    public void AsetHouseName(String newHouseName) {
        houseName = newHouseName;
    }

    public void AsetHousePrice(double newHousePrice) {
        housePrice = newHousePrice;
    }

    public void AsetNumRoomates(int newNumRoomates) {
        numRoomates = newNumRoomates;
    }



    public String AgetHouseName() {
        return houseName;
    }

    public double AgetHousePrice() {

        return housePrice;
    }

    public int AgetNumRoomates() {
        return numRoomates;
    }






}
