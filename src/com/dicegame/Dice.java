package com.dicegame;

import java.util.Random;

public class Dice {
    private static Random randomGenerator;
    int nrOfSides;
    int currnetSide;

    public Dice(int nrOfSides) {
        this.nrOfSides = nrOfSides;
        randomGenerator = new Random();
    }

    public int getNrOfSides() {
        return nrOfSides;
    }

    public int getCurrnetSide() {
        return currnetSide;
    }

    public void setCurrnetSide(int currnetSide) {
        this.currnetSide = currnetSide;
    }

    public void roll() {

        currnetSide = randomGenerator.nextInt(nrOfSides) + 1;
    }
}
